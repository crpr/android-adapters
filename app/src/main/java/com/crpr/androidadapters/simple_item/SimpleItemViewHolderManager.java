package com.crpr.androidadapters.simple_item;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.crpr.androidadapters.common.BaseViewHolder;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.ViewHolderManager;
import com.crpr.androidadapters.common.TemplateModel;
import com.crpr.androidadapters.generated.AnnotationContactTemplateBuilder;

import java.util.List;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class SimpleItemViewHolderManager implements ViewHolderManager<TemplateModel> {

    @Override
    public BaseViewHolder<TemplateModel> build(LayoutInflater inflater, ViewGroup parent, int viewType,
                                               RecyclerItemTouchListener listener) {
        return new AnnotationContactTemplateBuilder().build(inflater,parent,listener);
    }

    @Override
    public int getViewType(List<TemplateModel> models, int position) {
        return 0;
    }
}
