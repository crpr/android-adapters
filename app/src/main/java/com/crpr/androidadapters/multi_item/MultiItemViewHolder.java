package com.crpr.androidadapters.multi_item;

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
public class MultiItemViewHolder {

    static class Contact extends BaseViewHolder<AdapterModel> {
        private TextView name;
        private TextView email;

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

    static class Dummy extends BaseViewHolder<AdapterModel> {
        private TextView left;
        private TextView right;

        public Dummy(View itemView, RecyclerItemTouchListener listener) {
            super(itemView, listener);
        }

        @Override
        protected void bindView(View itemView) {
            left = (TextView) itemView.findViewById(R.id.dummy_left_label);
            right = (TextView) itemView.findViewById(R.id.dummy_right_label);
        }

        @Override
        protected void render(AdapterModel model, Context context) {
            this.left.setText(model.getDummy().getLeftLabel());
            this.right.setText(model.getDummy().getRightLabel());
        }

        public static Dummy getInstance(View view, RecyclerItemTouchListener listener){
            return new Dummy(view, listener);
        }
    }

    static class Separator extends BaseViewHolder<AdapterModel> {
        private TextView label;

        public Separator(View itemView, RecyclerItemTouchListener recyclerClickListener) {
            super(itemView, recyclerClickListener);
        }

        @Override
        protected void bindView(View itemView) {
            label = (TextView) itemView.findViewById(R.id.header_label);
        }

        @Override
        protected void render(AdapterModel model, Context context) {
            label.setText(model.getHeader().getLabel());
        }

        public static Separator getInstance(View view, RecyclerItemTouchListener listener){
            return new Separator(view, listener);
        }
    }
}
