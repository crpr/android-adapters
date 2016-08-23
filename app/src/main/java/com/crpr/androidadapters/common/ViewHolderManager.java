package com.crpr.androidadapters.common;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public interface ViewHolderManager<T> {

    BaseViewHolder<T> build(Context context, ViewGroup parent, int viewType,
                            RecyclerItemTouchListener listener);

    int getViewType(List<T> models, int position);

}
