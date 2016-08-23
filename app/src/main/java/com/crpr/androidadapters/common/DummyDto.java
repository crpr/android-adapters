package com.crpr.androidadapters.common;

/**
 * Created by claudioribeiro on 23/08/16.
 */
public class DummyDto {

    private String leftLabel;
    private String rightLabel;

    public DummyDto(String left, String right){
        this.setLeftLabel(left);
        this.setRightLabel(right);
    }

    public String getLeftLabel() {
        return leftLabel;
    }

    public void setLeftLabel(String leftLabel) {
        this.leftLabel = leftLabel;
    }

    public String getRightLabel() {
        return rightLabel;
    }

    public void setRightLabel(String rightLabel) {
        this.rightLabel = rightLabel;
    }
}
