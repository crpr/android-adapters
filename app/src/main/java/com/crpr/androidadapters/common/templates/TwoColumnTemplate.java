package com.crpr.androidadapters.common.templates;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.crpr.androidadapters.R;
import com.crpr.androidadapters.common.BaseViewHolder;
import com.crpr.androidadapters.common.RecyclerItemTouchListener;

/**
 * Created by claudioribeiro on 31/08/16.
 */
public class TwoColumnTemplate extends BaseViewHolder<TemplateModel> {

    public static final int TWO_COLUMN_TYPE = 2;

    public interface TwoColumnTemplateModel extends TemplateModel {
        String getLeftLabel();
        String getRightLabel();
    }

    private TextView left;
    private TextView right;

    public TwoColumnTemplate(View itemView, RecyclerItemTouchListener listener) {
        super(itemView, listener);
    }

    @Override
    protected void bindView(View itemView) {
        left = (TextView) itemView.findViewById(R.id.dummy_left_label);
        right = (TextView) itemView.findViewById(R.id.dummy_right_label);
    }

    @Override
    protected void render(TemplateModel model, Context context) {
        this.left.setText(((TwoColumnTemplateModel)model).getLeftLabel());
        this.right.setText(((TwoColumnTemplateModel)model).getRightLabel());
    }

    public static TwoColumnTemplate getInstance(View view, RecyclerItemTouchListener listener){
        return new TwoColumnTemplate(view, listener);
    }
}