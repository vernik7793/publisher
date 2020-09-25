package com.vernik7793;

import com.vernik7793.subscriber.IEventSubscriber;
import org.springframework.beans.factory.config.BeanPostProcessor;

public interface SubscriberBeanPostProcessor extends BeanPostProcessor {
    Iterable<IEventSubscriber> getSubscribersByEventType(String eventType);
}