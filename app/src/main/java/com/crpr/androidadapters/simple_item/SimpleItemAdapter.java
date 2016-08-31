package com.crpr.androidadapters.simple_item;

import android.content.Context;

import com.crpr.androidadapters.common.BaseAdapter;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.ViewHolderManager;
import com.crpr.androidadapters.common.templates.TemplateModel;

import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class SimpleItemAdapter extends BaseAdapter<TemplateModel>{

    public SimpleItemAdapter(Context context, ViewHolderManager<TemplateModel> manager,
                             List<TemplateModel> models, RecyclerItemTouchListener listener) {
        super(context, manager, models, listener);
    }

}
