package com.vernik7793.subscriber;

public interface IEventSubscriber {
    void onEvent(String name, Object obj);
}