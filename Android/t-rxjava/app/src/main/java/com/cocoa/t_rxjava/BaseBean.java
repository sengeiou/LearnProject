package com.cocoa.t_rxjava;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cocoa.rxjava.rxjava.BaseBean
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/2/27 17:04
 */
public class BaseBean<T> {
    private T weatherinfo;

    public T getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(T weatherinfo) {
        this.weatherinfo = weatherinfo;
    }
}
