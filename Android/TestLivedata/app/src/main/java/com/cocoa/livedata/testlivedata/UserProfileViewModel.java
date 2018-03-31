package com.cocoa.livedata.testlivedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

/**
 * Created by junshen on 2018/2/20.
 */

public class UserProfileViewModel extends ViewModel {

    private UserRepository userRepository;
    private LiveData<User> user;

    @Inject
    public UserProfileViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void init(String userId) {
        if(this.user != null) {
            return;
        }
        this.user = userRepository.getUser(userId);

    }

    public LiveData<User> getUser() {
        return user;
    }

}
