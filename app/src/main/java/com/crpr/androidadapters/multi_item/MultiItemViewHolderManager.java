package com.crpr.androidadapters.multi_item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.BaseViewHolder;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.ViewHolderManager;
import com.crpr.androidadapters.common.templates.ContactTemplate;
import com.crpr.androidadapters.common.templates.HeaderTemplate;
import com.crpr.androidadapters.common.templates.TemplateModel;
import com.crpr.androidadapters.common.templates.TwoColumnTemplate;

import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class MultiItemViewHolderManager implements ViewHolderManager<TemplateModel> {

    @Override
    public BaseViewHolder<TemplateModel> build(Context context, ViewGroup parent, int viewType,
                                              RecyclerItemTouchListener listener) {

        View view;

        switch (viewType){
            case ContactTemplate.CONTACT_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.layout_contact_item, parent, false);
                return ContactTemplate.getInstance(view, listener);
            case TwoColumnTemplate.TWO_COLUMN_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.layout_two_column_item, parent, false);
                return TwoColumnTemplate.getInstance(view, listener);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.layout_header_item, parent, false);
                return HeaderTemplate.getInstance(view, listener);

        }
    }

    @Override
    public int getViewType(List<TemplateModel> models, int position) {
        return models.get(position).getType();
    }
}
