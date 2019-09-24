package com.cocoa.livedata.testlivedata;

import android.arch.lifecycle.LiveData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junshen on 2018/2/21.
 */

public class UserCache {

    public Map<String,LiveData<User>> map = new HashMap<>();


    public LiveData<User> get(String userId){
        return  map.get(userId);
    }


    public void put(String userId,LiveData<User> data){
        map.put(userId,data);
    }

}
