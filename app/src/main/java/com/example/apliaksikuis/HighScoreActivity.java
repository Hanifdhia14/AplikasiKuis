package com.example.apliaksikuis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HighScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.high_score_activity);

        TextView txtScore = (TextView) findViewById(R.id.textScore);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your Score : " +score);

        SharedPreferences mypref= getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore",0);
        if (highscore>= score)
            txtHighScore.setText("High Score: "+ highscore);
        else {
            txtHighScore.setText("New highscore:"+score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();

        }
    }
    public void onClick(){
        Intent intent = new Intent(HighScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }


}

