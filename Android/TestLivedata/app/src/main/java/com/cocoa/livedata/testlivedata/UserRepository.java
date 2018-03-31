package com.cocoa.livedata.testlivedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by junshen on 2018/2/21.
 */
@Singleton
public class UserRepository {

    private Webservice webservice;
    private UserCache mUserCache;

    public LiveData<User> getUser(String userId) {
        // This is not an optimal implementation, we'll fix it below
        LiveData<User> cache = mUserCache.get(userId);

        if (cache != null) {
            return cache;
        }

        final MutableLiveData<User> data = new MutableLiveData<>();
        mUserCache.put(userId, data);
        webservice.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // error case is left out for brevity
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }

}
