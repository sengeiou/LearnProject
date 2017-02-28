package com.cocoa.rxjava.rxjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Context mContext;
    private TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt = (TextView) findViewById(R.id.tt);
        mContext = this;
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
                                Log.d(TAG+"hebing", base.toString());
                                Log.d(TAG+"hebing", base.getWeatherinfo().toString());
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
                        Log.d(TAG+"hebing", listHttpResult.getSubjects().get(0).toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG+"hebing", throwable.toString());
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
