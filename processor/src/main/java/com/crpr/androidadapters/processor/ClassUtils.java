package com.crpr.androidadapters.processor;

import com.squareup.javapoet.ClassName;

/**
 * Created by claudioribeiro on 21/09/16.
 */

class ClassUtils {

    private static final String BASE_PROJECT_PATH = "com.crpr.androidadapters.common";
    static final int BASE_TEMPLATE = 0;
    static final int BASE_VIEWHOLDER = 1;
    static final int TEMPLATE_MODEL = 2;

    static ClassName getClassNameByType(int type){
        switch (type){
            case BASE_TEMPLATE:
                return ClassName.get(BASE_PROJECT_PATH, "BaseTemplate");
            case BASE_VIEWHOLDER:
                return ClassName.get(BASE_PROJECT_PATH, "BaseViewHolder");
            case TEMPLATE_MODEL:
                return ClassName.get(BASE_PROJECT_PATH, "TemplateModel");
            default:
                return null;
        }
    }

}
