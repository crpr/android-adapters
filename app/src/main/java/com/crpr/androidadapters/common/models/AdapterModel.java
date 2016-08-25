package com.crpr.androidadapters.common.models;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class AdapterModel {

    public static final int CONTACT_TYPE = 0;
    public static final int DUMMY_TYPE = 1;
    public static final int SEPARATOR_TYPE = 2;

    private int type;
    private ContactDto contactDto;
    private DummyDto dummyDto;
    private HeaderDto headerDto;

    public AdapterModel(ContactDto contactDto){
        this.contactDto = contactDto;
        this.type = CONTACT_TYPE;
    }

    public AdapterModel(DummyDto dummyDto){
        this.dummyDto = dummyDto;
        this.type = DUMMY_TYPE;
    }

    public AdapterModel(HeaderDto headerDto){
        this.headerDto = headerDto;
        this.type = SEPARATOR_TYPE;
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

    public int getType() {
        return type;
    }
}
