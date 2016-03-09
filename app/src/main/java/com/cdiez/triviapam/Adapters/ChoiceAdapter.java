package com.cdiez.triviapam.Adapters;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdiez.triviapam.Model.Choice;
import com.cdiez.triviapam.R;

/**
 * Created by Carlos Diez
 * on 1/25/16.
 */

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ChoiceViewHolder> {

    private Choice[] mChoices;
    private MyChoiceClickListener mChoiceListener;
    private int mQuestionNumber;

    public ChoiceAdapter(Choice[] choices, MyChoiceClickListener choiceListener, int questionNumber) {
        mChoices = choices;
        mChoiceListener = choiceListener;
        mQuestionNumber = questionNumber;
    }

    @Override
    public ChoiceAdapter.ChoiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.choice_item, parent, false);
        return new ChoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChoiceAdapter.ChoiceViewHolder holder, final int position) {
        final Choice choice = mChoices[position];
        holder.bindChoice(choice);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext(), R.style.AppCompatAlertDialogStyle);
                View view;
                if (mQuestionNumber < 7) {
                    if (choice.getCorrect()) {
                        view = LayoutInflater.from(v.getContext()).inflate(R.layout.correct_title, null);
                        builder.setCustomTitle(view);
                        builder.setMessage("Respuesta correcta +10 puntos!");
                    } else {
                        view = LayoutInflater.from(v.getContext()).inflate(R.layout.incorrect_title, null);
                        builder.setCustomTitle(view);
                        builder.setMessage("Respuesta incorrecta -10 puntos.");
                    }
                    builder.setPositiveButton("SIGUIENTE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mChoiceListener.onChoiceClicked(mQuestionNumber + 1, choice.getCorrect());
                        }
                    });
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            mChoiceListener.onChoiceClicked(mQuestionNumber + 1, choice.getCorrect());
                        }
                    });
                }
                else {
                    if (choice.getCorrect()) {
                        view = LayoutInflater.from(v.getContext()).inflate(R.layout.last_correct_title, null);
                        builder.setCustomTitle(view);
                    }
                    else {
                        view = LayoutInflater.from(v.getContext()).inflate(R.layout.last_incorrect_title, null);
                        builder.setCustomTitle(view);
                    }
                }
                builder.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mChoices.length;
    }

    public class ChoiceViewHolder extends RecyclerView.ViewHolder {

        TextView mChoiceText;

        public ChoiceViewHolder(View itemView) {
            super(itemView);

            mChoiceText = (TextView) itemView.findViewById(R.id.choice);
        }

        public void bindChoice(Choice choice) {
            mChoiceText.setText(choice.getText());
        }
    }
}
