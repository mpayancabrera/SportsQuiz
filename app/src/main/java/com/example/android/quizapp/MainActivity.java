package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;
import static com.example.android.quizapp.R.string.question1;
import static com.example.android.quizapp.R.string.question2;
import static com.example.android.quizapp.R.string.question5;

public class MainActivity extends AppCompatActivity {

    private int rCorrectas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        rCorrectas = 0;
        rCorrectas += checkQuestion1();
        rCorrectas += checkQuestion2();
        rCorrectas += checkQuestion3();
        rCorrectas += checkQuestion4();
        rCorrectas += checkQuestion5();


        Intent mainIntent = new Intent(MainActivity.this, ResultActivity.class);
        mainIntent.putExtra("correct", rCorrectas);
        startActivity(mainIntent);
    }

    public int checkQuestion1(){
        RadioGroup q1 = (RadioGroup) findViewById(R.id.quest1);
        Boolean acierto;
        RadioButton rb = (RadioButton) findViewById(R.id.answer_13);
        switch (q1.getCheckedRadioButtonId()) {
            case R.id.answer_13:
                if (rb.isChecked()) {
                    acierto = true;
                    Log.v("MainActivity", "result 1 correct");
                    return 1;
                }
                break;
            default:
                acierto = false;
                break;
        }
        Log.v("MainActivity", "result 1 incorrect");
        return 0;

    }
    public int checkQuestion2(){
        RadioGroup q2 = (RadioGroup) findViewById(R.id.quest2);
        Boolean acierto;
        RadioButton rb = (RadioButton) findViewById(R.id.answer_21);
        switch (q2.getCheckedRadioButtonId()) {
            case R.id.answer_21:
                if (rb.isChecked()) {
                    acierto = true;
                    Log.v("MainActivity", "result 2 correct");
                    return 1;
                }
                break;
            default:
                acierto = false;
                break;
        }
        Log.v("MainActivity", "result 2 incorrect");
        return 0;
    }
    public int checkQuestion3(){
        CheckBox one = (CheckBox) findViewById(R.id.answer_31);
        boolean hasone = one.isChecked();

        CheckBox two = (CheckBox) findViewById(R.id.answer_32);
        boolean hastwo = two.isChecked();

        CheckBox three = (CheckBox) findViewById(R.id.answer_33);
        boolean hasthree = three.isChecked();

        if(hasone && hastwo && hasthree)
        {
            Log.v("MainActivity", "result 3 correct");
            return 1;
        }
        else{
            Log.v("MainActivity", "result 3 incorrect");
            return 0;
        }
    }
    public int checkQuestion4(){
        EditText text = (EditText) findViewById(R.id.answer_4);
        Editable nameEditable = text.getText();
        String name = nameEditable.toString().toUpperCase();

        if(name.equals("ROGER") || name.equals("BANNISTE") || name.equals("ROGER BANNISTE"))
        {
            Log.v("MainActivity", "result 4 correct" + name + nameEditable);
            return 1;
        }
        else {
            Log.v("MainActivity", "result 4 incorrect" + name + nameEditable);
            return 0;
        }
    }
    public int checkQuestion5(){
        RadioGroup q5 = (RadioGroup) findViewById(R.id.quest5);
        Boolean acierto;
        RadioButton rb = (RadioButton) findViewById(R.id.answer_53);
        switch (q5.getCheckedRadioButtonId()) {
            case R.id.answer_53:
                if (rb.isChecked()) {
                    acierto = true;
                    Log.v("MainActivity", "result 5 correct");
                    return 1;
                }
                break;
            default:
                acierto = false;
                break;
        }
        Log.v("MainActivity", "result 5 incorrect");
        return 0;
    }
}
