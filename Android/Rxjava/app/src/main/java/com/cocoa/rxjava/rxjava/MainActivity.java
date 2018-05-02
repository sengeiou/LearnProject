package com.cocoa.rxjava.rxjava;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cocoa.rxjava.rxjava.gx.BrandItem;
import com.cocoa.rxjava.rxjava.gx.CommSelectItem;
import com.cocoa.rxjava.rxjava.gx.CommTextAdapter;
import com.cocoa.rxjava.rxjava.oper.CreateActivity;
import com.cocoa.rxjava.rxjava.oper.TranActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//https://mcxiaoke.gitbooks.io/rxdocs/content/operators/Buffer.html
//https://www.imooc.com/video/15533
public class MainActivity extends AppCompatActivity implements Listener {
    public static final String TAG = "MainActivity";
    private TextView tt;
    private LinearLayout vpLayout;
    private LinearLayout indicatorLayout;
    private GridView gvPrice;
    ArrayList<GridFragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt = (TextView) findViewById(R.id.tt);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                range();
            }
        });
        findViewById(R.id.tram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TranActivity.class));
            }
        });
        findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }
        });

        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density = dm.density;
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        int span = 20;
        int vpWidth = width / 5 * 4;
        int cellWidth = (vpWidth - 4 * span) / 4;
        int defaultIndicatorIndex = 0;

        vpLayout = (LinearLayout) findViewById(R.id.vpLayout);
        indicatorLayout = (LinearLayout) findViewById(R.id.indicatorLayout);
        gvPrice = (GridView) findViewById(R.id.gvPrice);

        ViewPager vp = new ViewPager(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(vpWidth, cellWidth * 3 + 2 * span);
//        lp.setMargins(20, 20, 20, 20);
        vp.setLayoutParams(lp);

        vp.setId(R.id.vp);
        vp.setBackgroundColor(Color.parseColor("#ffffff"));
        vpLayout.addView(vp);

        list = new ArrayList<>();
        List<BrandItem> msgs = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            BrandItem item = new BrandItem();
            item.setId(String.valueOf(i));
            item.setText(String.valueOf(i));
            item.setImgUrl(String.valueOf(i));
            msgs.add(item);
        }

        List<CommSelectItem> commSelectItemList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            commSelectItemList.add(new CommSelectItem(String.valueOf(i)));
        }

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                vpWidth,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        gvPrice.setLayoutParams(param);

        gvPrice.setNumColumns(2);
        gvPrice.setVerticalSpacing(span);
        gvPrice.setHorizontalSpacing(span);
        CommTextAdapter commTextAdapterPrice = new CommTextAdapter(this, commSelectItemList, (vpWidth-span) / 2);
        gvPrice.setAdapter(commTextAdapterPrice);


        int size = 0;
        double temp = msgs.size() / 12.0;
        if (temp > (size = (int) temp)) {
            size++;
        }

        for (int i = 0; i < size; i++) {
            if (i == (size - 1)) {
                List<BrandItem> result = msgs.subList(i * 12, msgs.size());
                list.add(GridFragment.newInstance(result, cellWidth, this));
            } else {
                List<BrandItem> result = msgs.subList(i * 12, (i * 12) + 12);
                list.add(GridFragment.newInstance(result, cellWidth, this));
            }
            ImageView view = new ImageView(this);
            LinearLayout.LayoutParams viewlp = new LinearLayout.LayoutParams(20, 20);
            viewlp.setMargins(10, 0, 0, 0);
            view.setLayoutParams(viewlp);
            if (defaultIndicatorIndex == i) {
                view.setBackgroundColor(Color.parseColor("#FF5D5D"));
            } else {
                view.setBackgroundColor(Color.parseColor("#FFC4C4"));
            }
            indicatorLayout.addView(view);
        }
        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int count = indicatorLayout.getChildCount();
                for (int i = 0; i < count; i++) {
                    View view = indicatorLayout.getChildAt(i);
                    if (position == i) {
                        view.setBackgroundColor(Color.parseColor("#FF5D5D"));
                    } else {
                        view.setBackgroundColor(Color.parseColor("#FFC4C4"));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void change(String id) {
        for (GridFragment fragment : list) {
            fragment.change(id);
        }
    }

    void printMsg(String s) {
        Log.e("MainActivity", s);
    }


    void range() {
        Observable.range(0, 10).buffer(3).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Integer> integers) {
                printMsg(integers.size() + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                printMsg("onComplete");
            }
        });


    }


    void interval() {
        // 自增长
        final Observable observable = Observable.interval(2, TimeUnit.SECONDS);
        observable.subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                printMsg("onComplete");
            }
        });

    }


    void from() {
        Integer[] arrayInt = {1, 2, 3, 4, 5};
        Observable observable = Observable.fromArray(arrayInt);

        observable.subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                printMsg(o + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                printMsg("onComplete");
            }
        });
    }


    void empty() {
        Observable.empty().subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Object s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                printMsg(Thread.currentThread().getName());
                printMsg("onConplete");
            }
        });


    }

    void create() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

                e.onNext("1");
                e.onComplete();

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });


    }


    void code() {
        //
//        getMovie();


//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//
//                tt.setText("observable subscribe");
//                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
//                Log.d(TAG, "emit 100");
//                emitter.onNext(100);
//            }
//        });
//
//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//
//                tt.setText("consumer accept");
//                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
//                Log.d(TAG, "onNext: " + integer);
//            }
//        };
//
//        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, integer+"After observeOn(mainThread), current thread is: " + Thread.currentThread().getName());
//                    }
//                })
//                .observeOn(Schedulers.io())
//                .doOnNext(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.d(TAG, integer+"After observeOn(io), current thread is : " + Thread.currentThread().getName());
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(consumer);


// new Observer<Weatherinfo>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {}
//
//                    @Override
//                    public void onNext(Weatherinfo value) {
//                        Toast.makeText(mContext, value.getCity()+"====", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
//                    }
//                }


//******    把获取天气和电影写在一起 用flatMap  ****************

        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofitMovie = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        final MovieService movieService = retrofitMovie.create(MovieService.class);


        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(9, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.weather.com.cn/data/sk/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        api.getWeath()
                .subscribeOn(Schedulers.io())               //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
                .doOnNext(
                        new Consumer<BaseBean<Weatherinfo>>() {
                            @Override
                            public void accept(BaseBean<Weatherinfo> base) throws Exception {
                                Log.d(TAG + "hebing", base.toString());
                                Log.d(TAG + "hebing", base.getWeatherinfo().toString());
                            }
                        }
                ).observeOn(Schedulers.io())
                .flatMap(new Function<BaseBean<Weatherinfo>, ObservableSource<HttpResult<List<Subject>>>>() {
                    @Override
                    public ObservableSource<HttpResult<List<Subject>>> apply(BaseBean<Weatherinfo> weatherinfoBaseBean) throws Exception {
                        return movieService.getTopMovie(0, 10);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HttpResult<List<Subject>>>() {
                    @Override
                    public void accept(HttpResult<List<Subject>> listHttpResult) throws Exception {
                        Log.d(TAG + "hebing", listHttpResult.getSubjects().get(0).toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG + "hebing", throwable.toString());
                    }
                });


//******    把获取天气和电影写在一起 用flatMap  ****************
    }


    public void getWeather() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(9, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.weather.com.cn/data/sk/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        api.getWeath()
                .subscribeOn(Schedulers.io())               //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
                .subscribe(
                        new Consumer<BaseBean<Weatherinfo>>() {
                            @Override
                            public void accept(BaseBean<Weatherinfo> base) throws Exception {
                                Log.d(TAG, base.toString());
                                Log.d(TAG, base.getWeatherinfo().toString());
                            }
                        }
                );


    }

    private void getMovie() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);

        movieService.getTopMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HttpResult<List<Subject>>>() {
                    @Override
                    public void accept(HttpResult<List<Subject>> listHttpResult) throws Exception {
                        Log.e(TAG, listHttpResult.getSubjects().get(0).toString());
                    }
                });
    }


}

class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager mfragmentManager;
    private List<GridFragment> mlist;

    public TabFragmentPagerAdapter(FragmentManager fm, List<GridFragment> list) {
        super(fm);
        this.mlist = list;
    }

    @Override
    public Fragment getItem(int arg0) {
        return mlist.get(arg0);//显示第几个页面
    }

    @Override
    public int getCount() {
        return mlist.size();//有几个页面
    }
}
