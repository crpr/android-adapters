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
public class HeaderTemplate extends BaseViewHolder<TemplateModel> {

    public static final int HEADER_TYPE = 1;

    public interface HeaderTemplateModel extends TemplateModel {
        String getLabel();
    }

    private TextView label;

    public HeaderTemplate(View itemView, RecyclerItemTouchListener recyclerClickListener) {
        super(itemView, recyclerClickListener);
    }

    @Override
    protected void bindView(View itemView) {
        label = (TextView) itemView.findViewById(R.id.header_label);
    }

    @Override
    protected void render(TemplateModel model, Context context) {
        label.setText(((HeaderTemplateModel)model).getLabel());
    }

    public static HeaderTemplate getInstance(View view, RecyclerItemTouchListener listener){
        return new HeaderTemplate(view, listener);
    }
}
