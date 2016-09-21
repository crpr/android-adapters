package com.crpr.androidadapters.common.models;

import com.crpr.androidadapters.common.TemplateModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class AdapterListProvider {

    public static List<TemplateModel> getModels(){
        List<TemplateModel> models = new ArrayList<>();

        models.add(new HeaderDto("Contacts"));

        models.add(new ContactDto("john doe1", "john.doe1@at.com"));
        models.add(new ContactDto("john doe2", "john.doe2@at.com"));
        models.add(new ContactDto("john doe3", "john.doe3@at.com"));
        models.add(new ContactDto("john doe4", "john.doe4@at.com"));
        models.add(new ContactDto("john doe5", "john.doe5@at.com"));
        models.add(new ContactDto("john doe6", "john.doe6@at.com"));
        models.add(new ContactDto("john doe7", "john.doe7@at.com"));

        models.add(new HeaderDto("Dummy's"));

        models.add(new DummyDto("left1", "right1"));
        models.add(new DummyDto("left2", "right2"));
        models.add(new DummyDto("left3", "right3"));
        models.add(new DummyDto("left4", "right4"));
        models.add(new DummyDto("left5", "right5"));
        
        models.add(new ColumnsDto("leftCol1", "rightCol1"));
        models.add(new ColumnsDto("leftCol2", "rightCol2"));
        models.add(new ColumnsDto("leftCol3", "rightCol3"));
        models.add(new ColumnsDto("leftCol4", "rightCol4"));
        models.add(new ColumnsDto("leftCol5", "rightCol5"));

        return models;
    }

    public static List<TemplateModel> getContactModels(){
        List<TemplateModel> models = new ArrayList<>();

        models.add(new ContactDto("john doe1", "john.doe1@at.com"));
        models.add(new ContactDto("john doe2", "john.doe2@at.com"));
        models.add(new ContactDto("john doe3", "john.doe3@at.com"));
        models.add(new ContactDto("john doe4", "john.doe4@at.com"));
        models.add(new ContactDto("john doe5", "john.doe5@at.com"));
        models.add(new ContactDto("john doe6", "john.doe6@at.com"));
        models.add(new ContactDto("john doe7", "john.doe7@at.com"));

        return models;
    }

}
