package com.crpr.androidadapters.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView, RecyclerItemTouchListener listener) {
        super(itemView);
        bindView(itemView);
        bindListener(itemView, listener);
    }

    private void bindListener(final View itemView, final RecyclerItemTouchListener recyclerClickListener) {
        itemView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            recyclerClickListener.onTouch(itemView, getLayoutPosition());
                                        }
                                    });
    }

    protected abstract void bindView(final View itemView);

    protected abstract void render(T model, Context context);
}
