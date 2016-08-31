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
public class ContactTemplate extends BaseViewHolder<TemplateModel> {

    public static final int CONTACT_TYPE = 0;

    public interface ContactTemplateModel extends TemplateModel {
        String getTopLabel();
        String getBottomLabel();
    }

    private TextView topLabel;
    private TextView bottomLabel;

    public ContactTemplate(View itemView, RecyclerItemTouchListener listener) {
        super(itemView, listener);
    }

    @Override
    protected void bindView(View itemView) {
        topLabel = (TextView) itemView.findViewById(R.id.contact_top_label);
        bottomLabel = (TextView) itemView.findViewById(R.id.contact_bottom_label);
    }

    @Override
    protected void render(TemplateModel model, Context context) {
        this.topLabel.setText(((ContactTemplateModel)model).getTopLabel());
        this.bottomLabel.setText(((ContactTemplateModel)model).getBottomLabel());
    }

    public static ContactTemplate getInstance(View view, RecyclerItemTouchListener listener){
        return new ContactTemplate(view, listener);
    }
}
