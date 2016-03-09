package com.cdiez.triviapam.Model;

/**
 * Created by carlosdiez on 1/25/16.
 */
public class Choice {

    private String mText;
    private boolean mIsCorrect;

    public Choice(String text, boolean isCorrect) {
        mText = text;
        mIsCorrect = isCorrect;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public boolean getCorrect() {
        return mIsCorrect;
    }
}
