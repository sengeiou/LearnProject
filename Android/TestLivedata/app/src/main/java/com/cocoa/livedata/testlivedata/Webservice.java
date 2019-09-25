package com.cocoa.livedata.testlivedata;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by junshen on 2018/2/21.
 */
public interface Webservice {

    @GET("/headers")
    Call<User> getUser(String userId);
}
