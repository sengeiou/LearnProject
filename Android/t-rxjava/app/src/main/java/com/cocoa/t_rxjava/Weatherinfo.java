package com.cocoa.t_rxjava;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cocoa.rxjava.rxjava.Weatherinfo
 * @author: shenjun@kuaiqiangche.com
 * @date: 17/2/27 15:25
 */
public class Weatherinfo {
   private String city;
   private String cityid;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @Override
    public String toString() {
        return "Weatherinfo{" +
                "city='" + city + '\'' +
                ", cityid='" + cityid + '\'' +
                '}';
    }
}
