package com.example.lab06_notes_393_gavrilov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//Gavrilov 393
public class SecondActivity extends AppCompatActivity {

    int pos;
    EditText et_title, et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_title = findViewById(R.id.editText_Title);
        et_content = findViewById(R.id.editText_Content);

        Intent i = getIntent();
        String title = i.getStringExtra("my-note-title");
        String content = i.getStringExtra("my-note-content");
        pos = i.getIntExtra("my-note-index", -1);

        et_title.setText(title);
        et_content.setText(content);
    }

    public void onButtonCancel_Click(View v)
    {
        finish();
    }

    public void onButtonSave_Click(View v)
    {
        Intent i = new Intent();
        i.putExtra("my-note-index",pos);
        i.putExtra("my-note-title",et_title.getText().toString());
        i.putExtra("my-note-content",et_content.getText().toString());

        setResult(RESULT_OK,i);
        finish();
    }
}