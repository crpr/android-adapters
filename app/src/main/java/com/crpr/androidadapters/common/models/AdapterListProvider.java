package com.crpr.androidadapters.common.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class AdapterListProvider {

    public static List<AdapterModel> getModels(){
        List<AdapterModel> models = new ArrayList<>();

        models.add(new AdapterModel(new HeaderDto("Contacts")));

        models.add(new AdapterModel(new ContactDto("john doe1", "john.doe1@at.com")));
        models.add(new AdapterModel(new ContactDto("john doe2", "john.doe2@at.com")));
        models.add(new AdapterModel(new ContactDto("john doe3", "john.doe3@at.com")));
        models.add(new AdapterModel(new ContactDto("john doe4", "john.doe4@at.com")));
        models.add(new AdapterModel(new ContactDto("john doe5", "john.doe5@at.com")));
        models.add(new AdapterModel(new ContactDto("john doe6", "john.doe6@at.com")));
        models.add(new AdapterModel(new ContactDto("john doe7", "john.doe7@at.com")));

        models.add(new AdapterModel(new HeaderDto("Dummy's")));

        models.add(new AdapterModel(new DummyDto("left1", "right1")));
        models.add(new AdapterModel(new DummyDto("left2", "right2")));
        models.add(new AdapterModel(new DummyDto("left3", "right3")));
        models.add(new AdapterModel(new DummyDto("left4", "right4")));
        models.add(new AdapterModel(new DummyDto("left5", "right5")));

        return models;
    }

}
