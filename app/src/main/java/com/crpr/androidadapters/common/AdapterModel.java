package com.crpr.androidadapters.common;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class AdapterModel {

    private ContactDto contactDto;
    private DummyDto dummyDto;

    public AdapterModel(ContactDto contactDto){
        this.contactDto = contactDto;
    }

    public AdapterModel(DummyDto dummyDto){
        this.dummyDto = dummyDto;
    }

    public AdapterModel(){}

    public boolean isSeparator(){
        return contactDto == null && dummyDto == null;
    }

    public ContactDto getContact(){
        return contactDto;
    }

    public DummyDto getDummy(){
        return dummyDto;
    }
}
