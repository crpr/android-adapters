package com.crpr.androidadapters.common.models;

import com.crpr.androidadapters.common.templates.ContactTemplate;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class ContactDto implements ContactTemplate.ContactTemplateModel {

    private String name;
    private String email;

    public ContactDto(String name, String email){
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " - " + email;
    }

    @Override
    public String getTopLabel() {
        return getName();
    }

    @Override
    public String getBottomLabel() {
        return getEmail();
    }

    @Override
    public int getType() {
        return ContactTemplate.CONTACT_TYPE;
    }
}
