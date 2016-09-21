package com.crpr.androidadapters.common.templates;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.BaseViewHolder;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;
import com.crpr.androidadapters.common.TemplateModel;

/**
 * Created by claudioribeiro on 07/09/16.
 */
public class AnnotationContactTemplateViewHolder extends BaseViewHolder<TemplateModel> {

        private TextView topLabel;
        private TextView bottomLabel;

        public AnnotationContactTemplateViewHolder(View itemView, RecyclerItemTouchListener listener) {
        super(itemView, listener);
    }

        @Override
        protected void bindView(View itemView) {
        topLabel = (TextView) itemView.findViewById(R.id.contact_top_label);
        bottomLabel = (TextView) itemView.findViewById(R.id.contact_bottom_label);
    }

        @Override
        protected void render(TemplateModel model, Context context) {
            this.topLabel.setText(((ContactTemplate.Model) model).getTopLabel());
            this.bottomLabel.setText(((ContactTemplate.Model) model).getBottomLabel());
        }

}
