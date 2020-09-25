package com.vernik7793.publisher;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public interface Publisher extends ApplicationListener<ContextRefreshedEvent> {
    void send(String name, Object obj);
}