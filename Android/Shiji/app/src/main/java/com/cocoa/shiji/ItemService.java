package com.cocoa.shiji;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by junshen on 2017/12/27.
 */

public interface ItemService {

    @GET("getItems")
    Call<List<Object>> getItems(@Query("status") int start);
}
