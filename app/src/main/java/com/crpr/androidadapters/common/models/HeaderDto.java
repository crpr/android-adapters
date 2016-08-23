package com.crpr.androidadapters.common.models;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class HeaderDto {

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
}
