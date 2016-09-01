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

/**
 * Created by claudioribeiro on 31/08/16.
 */
public class ContactTemplate extends BaseTemplate<TemplateModel> {

    public static final int CONTACT_TYPE = 0;

    public interface Model extends TemplateModel {
        String getTopLabel();
        String getBottomLabel();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_contact_item;
    }

    @Override
    public BaseViewHolder<TemplateModel> build(LayoutInflater inflater, ViewGroup parent,
                                               RecyclerItemTouchListener listener) {
        return new ContactTemplateViewHolder(inflate(inflater, parent), listener);
    }

    private static class ContactTemplateViewHolder extends BaseViewHolder<TemplateModel> {

        private TextView topLabel;
        private TextView bottomLabel;

        public ContactTemplateViewHolder(View itemView, RecyclerItemTouchListener listener) {
            super(itemView, listener);
        }

        @Override
        protected void bindView(View itemView) {
            topLabel = (TextView) itemView.findViewById(R.id.contact_top_label);
            bottomLabel = (TextView) itemView.findViewById(R.id.contact_bottom_label);
        }

        @Override
        protected void render(TemplateModel model, Context context) {
            this.topLabel.setText(((Model)model).getTopLabel());
            this.bottomLabel.setText(((Model)model).getBottomLabel());
        }
    }
}
