package com.cocoa.shiji;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.constants.AlibcConstants;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.model.TradeResult;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.cocoa.base.BaseActivity;
import com.cocoa.base.BaseOnClickListener;
import com.cocoa.shiji.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends BaseActivity {

    public static final String BASE_URL = "http://116.196.79.208:8080/product/server/";


    private static final String TAG = "MainActivity";

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onActivityCreate(@Nullable Bundle savedInstanceState) {

        ActivityMainBinding mainBinding = (ActivityMainBinding) mViewDataBinding;
        mainBinding.setVariable(com.cocoa.shiji.BR.user, new User("cocoa"));
        mainBinding.setOnClick(new BaseOnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail("536483785151");
            }
        });

        //getItems?status=0

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        ItemService itemService = retrofit.create(ItemService.class);

        Call call = itemService.getItems(0);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.e(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                  e.onNext("1");
                  e.onNext("2");
                  e.onNext("3");
                  e.onComplete();
            }
        });
        observable.subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
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

    private void openDetail(String num_iid) {

        Map<String, String> exParams = new HashMap<>();
        exParams.put(AlibcConstants.ISV_CODE, "appisvcode");
        exParams.put(AlibcConstants.TAOKE_PID, "mm_44823234_8206093_28096268");
        //商品详情page
        AlibcBasePage detailPage = new AlibcDetailPage(num_iid);
        //设置页面打开方式
        AlibcShowParams showParams = new AlibcShowParams(OpenType.Auto, false);
        AlibcTaokeParams taokeParams = new AlibcTaokeParams("mm_44823234_8206093_28096268", "", "");
        //使用百川sdk提供默认的Activity打开detail
        AlibcTrade.show(this, detailPage, showParams, taokeParams, exParams,
                new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(TradeResult tradeResult) {
                        //打开电商组件，用户操作中成功信息回调。tradeResult：成功信息（结果类型：加购，支付；支付结果）
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        Log.e(TAG, msg + code);
                    }
                });

    }
}
