package com.crpr.androidadapters.multi_item;

import android.view.LayoutInflater;
import android.view.ViewGroup;

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
    public BaseViewHolder<TemplateModel> build(LayoutInflater inflater, ViewGroup parent, int viewType,
                                              RecyclerItemTouchListener listener) {

        switch (viewType){
            case ContactTemplate.CONTACT_TYPE:
                return new ContactTemplate().build(inflater, parent, listener);
            case TwoColumnTemplate.TWO_COLUMN_TYPE:
                return new TwoColumnTemplate().build(inflater, parent, listener);
            default:
                return new HeaderTemplate().build(inflater, parent, listener);

        }
    }

    @Override
    public int getViewType(List<TemplateModel> models, int position) {
        return models.get(position).getType();
    }
}
