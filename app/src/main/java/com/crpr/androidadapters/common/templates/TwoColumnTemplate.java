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
public class TwoColumnTemplate extends BaseTemplate<TemplateModel> {

    public static final int TWO_COLUMN_TYPE = 2;

    public interface Model extends TemplateModel {
        String getLeftLabel();
        String getRightLabel();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_two_column_item;
    }

    @Override
    public BaseViewHolder<TemplateModel> build(LayoutInflater inflater, ViewGroup parent,
                                               RecyclerItemTouchListener listener) {
        return new TwoColumnViewHolder(inflate(inflater, parent), listener);
    }

    private static class TwoColumnViewHolder extends BaseViewHolder<TemplateModel> {

        private TextView left;
        private TextView right;

        public TwoColumnViewHolder(View itemView, RecyclerItemTouchListener listener) {
            super(itemView, listener);
        }

        @Override
        protected void bindView(View itemView) {
            left = (TextView) itemView.findViewById(R.id.dummy_left_label);
            right = (TextView) itemView.findViewById(R.id.dummy_right_label);
        }

        @Override
        protected void render(TemplateModel model, Context context) {
            this.left.setText(((Model) model).getLeftLabel());
            this.right.setText(((Model) model).getRightLabel());
        }
    }
}