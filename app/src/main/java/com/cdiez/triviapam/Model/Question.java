package com.cdiez.triviapam.Model;

/**
 * Created by carlosdiez on 1/25/16.
 */
public class Question {

    private String mQuestion;
    private Choice[] mChoices;

    public Question(String question, Choice[] choices) {
        mQuestion = question;
        mChoices = choices;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public Choice getChoice(int choice) {
        return mChoices[choice];
    }

    public void setChoice(int index, Choice choice) {
        mChoices[index] = choice;
    }

    public Choice[] getChoices() {
        return mChoices;
    }

    public void setChoices(Choice[] choices) {
        mChoices = choices;
    }
}
