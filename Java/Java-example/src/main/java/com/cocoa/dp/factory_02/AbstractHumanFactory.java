package com.cocoa.dp.factory_02;

public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clazz);
}
