package com.example.apliaksikuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<view> extends AppCompatActivity {
    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mscoreView; //untuk menampilkan skorsaat ini
    private TextView mQuestionView; //menapilkan jawaban
    private Button mButtonChoice1; //jawaban 1
    private Button mButtonChoice2; //Jawaban 2
    private Button mButtonChoice3; //Jawaban 3
    private Button mButtonChoice4; //jawaban 4

    private String mAnswer; // untuk cek jawaban benar atau tidak
    private int mScore = 0; //current total score
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mscoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        updateQuestion();

        updateScore(mScore);
    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibrary.getLength()) {

            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoices(mQuestionNumber, 1));
            mButtonChoice1.setText(mQuestionLibrary.getChoices(mQuestionNumber, 2));
            mButtonChoice1.setText(mQuestionLibrary.getChoices(mQuestionNumber, 3));
            mButtonChoice1.setText(mQuestionLibrary.getChoices(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(MainActivity.this, "it was the last question !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HighScoreActivity.class);
            intent.putExtra("Score", mScore);
            startActivity(intent);
        }
    }

    private void updateScore(int point) {
        mscoreView.setText("" + mScore + "/" + mQuestionLibrary.getLength());
    }

    public void onClick(View view) {

        Button answer = (Button) view;

        if (answer.getText() == mAnswer) {
            mScore = mScore + 1;
            Toast.makeText(MainActivity.this, "Benar !!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(MainActivity.this, "Salah !!", Toast.LENGTH_SHORT).show();
        updateScore(mScore);
        updateQuestion();
    }
}



