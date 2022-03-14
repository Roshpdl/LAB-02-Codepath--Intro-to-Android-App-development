package com.example.myflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

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
        ImageView crosseye = findViewById(R.id.crosstheeye);

        wrongans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongans1.setBackgroundColor(getResources().getColor(R.color.red,null));

            }
        });

        wrongans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongans2.setBackgroundColor(getResources().getColor(R.color.red,null));

            }
        });

        flashcardAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardAnswer.setBackgroundColor(getResources().getColor(R.color.green,null));

            }
        });

        crosseye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongans1.setVisibility(View.INVISIBLE);
                wrongans2.setVisibility(View.INVISIBLE);
                flashcardAnswer.setVisibility(View.INVISIBLE);
                crosseye.setVisibility(View.INVISIBLE);
                toggle_choices_visibility.setVisibility(View.VISIBLE);

            }
        });

        toggle_choices_visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongans1.setVisibility(View.VISIBLE);
                wrongans2.setVisibility(View.VISIBLE);
                flashcardAnswer.setVisibility(View.VISIBLE);
                toggle_choices_visibility.setVisibility(View.INVISIBLE);
                crosseye.setVisibility(View.VISIBLE);
            }
        });
    }
}