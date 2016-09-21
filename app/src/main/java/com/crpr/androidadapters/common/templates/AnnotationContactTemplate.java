package com.crpr.androidadapters.common.templates;

import android.widget.TextView;

import com.crpr.androidadapters.AdapterTemplate;
import com.crpr.androidadapters.R;
import com.crpr.androidadapters.ViewHolderField;

/**
 * Created by claudioribeiro on 05/09/16.
 */
@AdapterTemplate(
        layout = R.layout.layout_contact_item,
        view_holder_class = AnnotationContactTemplateViewHolder.class)
public class AnnotationContactTemplate {

    @ViewHolderField(id = R.id.contact_top_label, name = "topLabel")
    TextView topLabel;

    @ViewHolderField(id = R.id.contact_top_label, name = "bottomLabel")
    TextView bottomLabel;

}
