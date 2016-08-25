package com.crpr.androidadapters.multi_item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.BaseViewHolder;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.ViewHolderManager;
import com.crpr.androidadapters.common.models.AdapterModel;

import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class MultiItemViewHolderManager implements ViewHolderManager<AdapterModel> {

    @Override
    public BaseViewHolder<AdapterModel> build(Context context, ViewGroup parent, int viewType,
                                              RecyclerItemTouchListener listener) {

        View view;

        switch (viewType){
            case AdapterModel.CONTACT_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.layout_contact_item, parent, false);
                return MultiItemViewHolder.Contact.getInstance(view, listener);
            case AdapterModel.DUMMY_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.layout_dummy_item, parent, false);
                return MultiItemViewHolder.Dummy.getInstance(view, listener);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.layout_separator_item, parent, false);
                return MultiItemViewHolder.Separator.getInstance(view, listener);

        }
    }

    @Override
    public int getViewType(List<AdapterModel> models, int position) {
        return models.get(position).getType();
    }
}
