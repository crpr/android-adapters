package com.crpr.androidadapters.common.templates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.BaseTemplate;
import com.crpr.androidadapters.common.BaseViewHolder;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.TemplateModel;

/**
 * Created by claudioribeiro on 31/08/16.
 */
public class HeaderTemplate extends BaseTemplate<TemplateModel> {

    public static final int HEADER_TYPE = 1;

    public interface Model extends TemplateModel {
        String getLabel();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_header_item;
    }

    @Override
    public BaseViewHolder<TemplateModel> build(LayoutInflater inflater, ViewGroup parent,
                                               RecyclerItemTouchListener listener) {
        return new HeaderTemplateViewHolder(inflate(inflater, parent), listener);
    }

    private static class HeaderTemplateViewHolder extends BaseViewHolder<TemplateModel> {

        private TextView label;

        public HeaderTemplateViewHolder(View itemView, RecyclerItemTouchListener listener) {
            super(itemView, listener);
        }

        @Override
        protected void bindView(View itemView) {
            label = (TextView) itemView.findViewById(R.id.header_label);
        }

        @Override
        protected void render(TemplateModel model, Context context) {
            label.setText(((Model) model).getLabel());
        }
    }
}
