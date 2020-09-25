package com.vernik7793.subscriber;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Subscriber {
    String[] eventTypes();
}
