package com.crpr.androidadapters.simple_item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.BaseViewHolder;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.models.AdapterModel;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class SimpleItemViewHolder {

    static class Contact extends BaseViewHolder<AdapterModel> {

        TextView name;
        TextView email;

        public Contact(View itemView, RecyclerItemTouchListener listener) {
            super(itemView, listener);
        }

        @Override
        protected void bindView(View itemView) {
            name = (TextView) itemView.findViewById(R.id.contact_top_label);
            email = (TextView) itemView.findViewById(R.id.contact_bottom_label);
        }

        @Override
        protected void render(AdapterModel model, Context context) {
            this.name.setText(model.getContact().getName());
            this.email.setText(model.getContact().getEmail());
        }

        public static Contact getInstance(View view, RecyclerItemTouchListener listener){
            return new Contact(view, listener);
        }
    }
}
