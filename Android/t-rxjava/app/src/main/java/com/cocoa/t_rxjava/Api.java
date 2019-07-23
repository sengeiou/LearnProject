package com.cocoa.t_rxjava;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cocoa.rxjava.rxjava.Api
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/2/27 15:19
 */
public interface Api {

    //http://www.weather.com.cn/data/sk/101010100.html
    @GET("101010100.html")
    Observable<BaseBean<Weatherinfo>> getWeath();


}
