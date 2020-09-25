package com.vernik7793.config;

import com.vernik7793.SubscriberBeanPostProcessor;
import com.vernik7793.SubscriberBeanPostProcessorImpl;
import com.vernik7793.publisher.Publisher;
import com.vernik7793.publisher.PublisherImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfiguration {
    @Bean
    public static SubscriberBeanPostProcessor subscriberBeanPostProcessor() {
        return new SubscriberBeanPostProcessorImpl();
    }

    @Bean
    public Publisher publisher() {
        return new PublisherImpl();
    }
}