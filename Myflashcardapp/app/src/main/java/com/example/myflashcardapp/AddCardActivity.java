package com.example.myflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_question_activity);

        findViewById(R.id.cancel_saving_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.save_button_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                String inputQuestion =((EditText)findViewById(R.id.new_question_edittext)).getText().toString();
                String inputAnswer = ((EditText)findViewById(R.id.flashcard_answer_edittext)).getText().toString();
                data.putExtra("Question_Key", inputQuestion);
                data.putExtra("Answer_Key", inputAnswer);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}