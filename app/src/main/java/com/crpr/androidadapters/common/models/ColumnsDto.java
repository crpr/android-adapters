package com.crpr.androidadapters.common.models;

import com.crpr.androidadapters.common.templates.TwoColumnTemplate;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class ColumnsDto implements TwoColumnTemplate.TwoColumnTemplateModel{

    private String leftColLabel;
    private String rightColLabel;

    public ColumnsDto(String left, String right){
        this.setLeftColLabel(left);
        this.setRightColLabel(right);
    }

    public String getLeftColLabel() {
        return leftColLabel;
    }

    public void setLeftColLabel(String leftColLabel) {
        this.leftColLabel = leftColLabel;
    }

    public String getRightColLabel() {
        return rightColLabel;
    }

    public void setRightColLabel(String rightLabel) {
        this.rightColLabel = rightLabel;
    }

    @Override
    public String getLeftLabel() {
        return getLeftColLabel();
    }

    @Override
    public String getRightLabel() {
        return getRightColLabel();
    }

    @Override
    public String toString() {
        return leftColLabel + " - " + rightColLabel;
    }

    @Override
    public int getType() {
        return TwoColumnTemplate.TWO_COLUMN_TYPE;
    }
}
