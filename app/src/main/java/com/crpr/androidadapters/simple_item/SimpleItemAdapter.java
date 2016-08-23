package com.crpr.androidadapters.simple_item;

import android.content.Context;

import com.crpr.androidadapters.common.BaseAdapter;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.ViewHolderManager;
import com.crpr.androidadapters.common.models.AdapterModel;

import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class SimpleItemAdapter extends BaseAdapter<AdapterModel>{

    public SimpleItemAdapter(Context context, ViewHolderManager<AdapterModel> manager,
                             List<AdapterModel> models, RecyclerItemTouchListener listener) {
        super(context, manager, models, listener);
    }

}
