package com.vernik7793;

import com.vernik7793.subscriber.IEventSubscriber;
import com.vernik7793.subscriber.Subscriber;
import org.springframework.beans.BeansException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class SubscriberBeanPostProcessorImpl implements SubscriberBeanPostProcessor {

    private final Map<IEventSubscriber, Set<String>> eventTypesBySubscriber = new WeakHashMap<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof IEventSubscriber) {
            if (bean.getClass().isAnnotationPresent(Subscriber.class)) {
                Subscriber annotation = bean.getClass().getAnnotation(Subscriber.class);
                Set<String> eventTypes = new HashSet<>(asList(annotation.eventTypes()));
                eventTypesBySubscriber.put((IEventSubscriber) bean, eventTypes);
            }
        }
        return bean;
    }

    @Override
    public Iterable<IEventSubscriber> getSubscribersByEventType(String eventType) {
        Predicate<Map.Entry<IEventSubscriber, Set<String>>> isSubscribeOnEventType = e  -> e.getValue().contains(eventType);
        return eventTypesBySubscriber.entrySet().stream()
                .filter(isSubscribeOnEventType)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

}