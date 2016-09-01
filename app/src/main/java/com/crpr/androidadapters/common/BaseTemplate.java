package com.crpr.androidadapters.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by claudioribeiro on 01/09/16.
 */
public abstract class BaseTemplate<T> {

    protected abstract int getLayoutResId();

    public abstract BaseViewHolder<T> build(LayoutInflater inflater, ViewGroup parent,
                                               RecyclerItemTouchListener listener);

    public View inflate(LayoutInflater inflater, ViewGroup parent){
        return inflater.inflate(getLayoutResId(), parent, false);
    }
}
