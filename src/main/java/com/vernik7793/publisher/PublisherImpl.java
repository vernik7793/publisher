package com.vernik7793.publisher;

import com.vernik7793.SubscriberBeanPostProcessor;
import com.vernik7793.subscriber.IEventSubscriber;
import org.springframework.context.event.ContextRefreshedEvent;

public class PublisherImpl implements Publisher {
    private SubscriberBeanPostProcessor postProcessor;

    @Override
    public void send(final String name, final Object obj) {
        Iterable<IEventSubscriber> subscribers = postProcessor.getSubscribersByEventType(name);
        subscribers.forEach(s -> s.onEvent(name, obj));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.postProcessor = event.getApplicationContext().getBean("subscriberBeanPostProcessor", SubscriberBeanPostProcessor.class);
    }

}