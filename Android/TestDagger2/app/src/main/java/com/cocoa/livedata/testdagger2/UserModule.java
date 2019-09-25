package com.cocoa.livedata.testdagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by junshen on 2018/2/22.
 */

@Module
public class UserModule {
    @Singleton
    @Provides
    User provideUser(){
        return new User("cocoa",12);
    }

}
