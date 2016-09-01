package com.crpr.androidadapters.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    private final Context context;
    private final LayoutInflater inflater;
    protected final ViewHolderManager<T> holderManager;
    protected List<T> models;
    private final RecyclerItemTouchListener listener;

    public BaseAdapter(Context context, ViewHolderManager<T> manager, List<T> models,
                       RecyclerItemTouchListener listener){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.holderManager = manager;
        this.models = models;
        this.listener = listener;
    }

    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return holderManager.build(inflater, parent, viewType, listener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        holder.render(models.get(position), context);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public T getItemByPosition(int position){
        return models.get(position);
    }

    public void updateItems(List<T> newItems){
        if(models == null){
            models = new ArrayList<>();
        } else {
            models.clear();
        }

        models.addAll(newItems);

        notifyDataSetChanged();
    }
}
