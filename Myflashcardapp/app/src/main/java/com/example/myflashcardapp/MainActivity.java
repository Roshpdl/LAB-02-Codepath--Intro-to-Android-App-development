package com.example.myflashcardapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView flashcardQuestion = findViewById(R.id.flashcard_question_textview);
        TextView flashcardAnswer = findViewById(R.id.flashcard_answer_textview);
        TextView wrongans1 = findViewById(R.id.flashcard_wronganswer1_textview);
        TextView wrongans2 = findViewById(R.id.flashcard_wronganswer2_textview);
        ImageView toggle_choices_visibility = findViewById(R.id.toggle_choices_visibility);

        wrongans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongans1.setBackgroundColor(getResources().getColor(R.color.red, null));

            }
        });

        wrongans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongans2.setBackgroundColor(getResources().getColor(R.color.red, null));

            }
        });

        flashcardAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardAnswer.setBackgroundColor(getResources().getColor(R.color.green, null));

            }
        });

        final boolean[] isShowingAnswerChoices = {true};
        toggle_choices_visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowingAnswerChoices[0]) {
                    toggle_choices_visibility.setImageResource(R.drawable.eye_icon);
                    wrongans1.setVisibility(View.INVISIBLE);
                    wrongans2.setVisibility(View.INVISIBLE);
                    flashcardAnswer.setVisibility(View.INVISIBLE);
                    isShowingAnswerChoices[0] = false;


                } else {
                    toggle_choices_visibility.setImageResource(R.drawable.eye_iconcrossed);
                    wrongans1.setVisibility(View.VISIBLE);
                    wrongans2.setVisibility(View.VISIBLE);
                    flashcardAnswer.setVisibility(View.VISIBLE);
                    isShowingAnswerChoices[0] = true;
                }

            }
        });

        ImageView addquestion = findViewById(R.id.add_button);
        addquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
//                startActivity(intent);
//                startActivityForResult(intent, 100);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });
    }
//Notice that the next line is not under OnCreate
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            //get data
            if (data != null) { //check if there is an intent
                String questionstring = data.getExtras().getString("Question_Key");
                String answerstring = data.getExtras().getString("Answer_Key");
                ((TextView)findViewById(R.id.flashcard_question_textview)).setText(questionstring);
                ((TextView)findViewById(R.id.flashcard_answer_textview)).setText(answerstring);
                ((TextView)findViewById(R.id.flashcard_wronganswer1_textview)).setText("No option added");
                ((TextView)findViewById(R.id.flashcard_wronganswer2_textview)).setText("No option added");

            }
        }
    }
}