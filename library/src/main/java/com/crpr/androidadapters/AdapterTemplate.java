package com.crpr.androidadapters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by claudioribeiro on 05/09/16.
 */
@Target(ElementType.TYPE) @Retention(RetentionPolicy.CLASS)
public @interface AdapterTemplate {
    int layout();
    Class view_holder_class();
}
