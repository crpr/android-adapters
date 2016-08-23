package com.crpr.androidadapters.common;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class ContactDto {

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
}
