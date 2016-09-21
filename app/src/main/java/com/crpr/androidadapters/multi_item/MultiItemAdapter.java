package com.crpr.androidadapters.multi_item;

import android.content.Context;

import com.crpr.androidadapters.common.BaseAdapter;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.ViewHolderManager;
import com.crpr.androidadapters.common.TemplateModel;

import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class MultiItemAdapter extends BaseAdapter<TemplateModel>{

    public MultiItemAdapter(Context context, ViewHolderManager<TemplateModel> manager,
                            List<TemplateModel> models, RecyclerItemTouchListener listener) {
        super(context, manager, models, listener);
    }

    @Override
    public int getItemViewType(int position) {
        return holderManager.getViewType(models, position);
    }
}
