package com.cocoa.livedata.testdagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by junshen on 2018/2/22.
 */
@Singleton
@Component(modules = UserModule.class)
public interface UserComponent {
    void inject(MainActivity activity);
}
