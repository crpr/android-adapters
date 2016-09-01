package com.crpr.androidadapters.common.models;

import com.crpr.androidadapters.common.templates.HeaderTemplate;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class HeaderDto implements HeaderTemplate.Model {

    private String label;

    public HeaderDto(String label){
        this.setLabel(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int getType() {
        return HeaderTemplate.HEADER_TYPE;
    }
}
