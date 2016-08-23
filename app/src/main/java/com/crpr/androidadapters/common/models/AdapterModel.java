package com.crpr.androidadapters.common.models;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class AdapterModel {

    private ContactDto contactDto;
    private DummyDto dummyDto;
    private HeaderDto headerDto;

    public AdapterModel(ContactDto contactDto){
        this.contactDto = contactDto;
    }

    public AdapterModel(DummyDto dummyDto){
        this.dummyDto = dummyDto;
    }

    public AdapterModel(HeaderDto headerDto){
        this.headerDto = headerDto;
    }

    public boolean isSeparator(){
        return headerDto != null;
    }

    public ContactDto getContact(){
        return contactDto;
    }

    public DummyDto getDummy(){
        return dummyDto;
    }

    public HeaderDto getHeader(){
        return headerDto;
    }
}
