package com.cdiez.triviapam.View;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cdiez.triviapam.Adapters.ChoiceAdapter;
import com.cdiez.triviapam.Adapters.MyChoiceClickListener;
import com.cdiez.triviapam.Model.Choice;
import com.cdiez.triviapam.Model.Question;
import com.cdiez.triviapam.Model.Trivia;
import com.cdiez.triviapam.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyChoiceClickListener{

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.question) TextView mQuestionText;
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    @Bind(R.id.score) TextView mScoreText;
    @Bind(R.id.question_number) TextView mQuestionNumberText;
    @Bind(R.id.view_0) View mView0;
    @Bind(R.id.view_1) View mView1;
    @Bind(R.id.view_2) View mView2;
    @Bind(R.id.view_3) View mView3;
    @Bind(R.id.view_4) View mView4;
    @Bind(R.id.view_5) View mView5;
    @Bind(R.id.view_6) View mView6;
    @Bind(R.id.view_7) View mView7;

    private Trivia mTrivia = new Trivia();
    private MyChoiceClickListener mMyChoiceClickListener;
    private int mScore = 10;
    private List<View> mViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setTitle(getResources().getString(R.string.title_activity_main));

        mRecyclerView.setHasFixedSize(true);

        mViews.add(mView0);
        mViews.add(mView1);
        mViews.add(mView2);
        mViews.add(mView3);
        mViews.add(mView4);
        mViews.add(mView5);
        mViews.add(mView6);
        mViews.add(mView7);

        mMyChoiceClickListener = this;

        mMyChoiceClickListener.onChoiceClicked(0, false);
    }

    @Override
    public void onChoiceClicked(int questionNumber, boolean isCorrect) {
        Question question = mTrivia.getQuestion(questionNumber);
        Choice[] choices = question.getChoices();
        int barColor;

        mQuestionText.setText(question.getQuestion());
        String questionString = "Pregunta " + (questionNumber+1);
        mQuestionNumberText.setText(questionString);

        if (isCorrect) {
            mScore += 10;
            barColor = ContextCompat.getColor(this, R.color.correct);
        }
        else {
            mScore -= 10;
            barColor = ContextCompat.getColor(this, R.color.incorrect);
        }

        int color = 0;
        if (mScore == 0) {
            color = ContextCompat.getColor(this, android.R.color.darker_gray);
        }
        else if (mScore > 0) {
            color = ContextCompat.getColor(this, R.color.correct);
        }
        else if (mScore < 0) {
            color = ContextCompat.getColor(this, R.color.incorrect);
        }

        String score = "Puntos: " + mScore;
        mScoreText.setText(score);

        mScoreText.setTextColor(color);

        ChoiceAdapter adapter = new ChoiceAdapter(choices, mMyChoiceClickListener, questionNumber);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

        if (questionNumber != 0) {
            mViews.get(questionNumber-1).setBackgroundColor(barColor);
            mViews.get(questionNumber).setVisibility(View.VISIBLE);
        }
    }
}