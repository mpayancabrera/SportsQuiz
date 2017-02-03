package com.example.android.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import static android.R.attr.name;

/**
 * Created by Manuel on 03/02/2017.
 */

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        TextView phrase = (TextView) findViewById(R.id.phrase);
        TextView thanks = (TextView) findViewById(R.id.thanks);

        Bundle datos = this.getIntent().getExtras();
        int aciertos = datos.getInt("correct");

        RatingBar stars = (RatingBar) findViewById(R.id.rating_bar);
        switch (aciertos) {
            case 0:
                phrase.setText("You have no idea!");
                stars.setRating(0);
                break;
            case 1:
                phrase.setText("Ohhh, bad result");
                stars.setRating(1);
                break;
            case 2:
                phrase.setText("You need improve!");
                stars.setRating(2);
                break;
            case 3:
                phrase.setText("It is not a bad result!");
                stars.setRating(3);
                break;
            case 4:
                phrase.setText("Good result!");
                stars.setRating(4);
                break;
            case 5:
                phrase.setText("Awesome!");
                stars.setRating(5);
                break;
        }

        thanks.setText("Thanks so much for taking part!");
    }
}
