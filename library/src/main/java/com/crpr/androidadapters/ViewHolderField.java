package com.crpr.androidadapters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by claudioribeiro on 05/09/16.
 */
@Target(ElementType.FIELD) @Retention(RetentionPolicy.CLASS)
public @interface ViewHolderField {

    int id();

    String name();

}
