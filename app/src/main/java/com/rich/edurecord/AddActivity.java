package com.rich.edurecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name_input, nim_input, ipk_input, course_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.name_input);
        nim_input = findViewById(R.id.nim_input);
        ipk_input = findViewById(R.id.ipk_input);
        course_input = findViewById(R.id.course_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addStudent(
                        name_input.getText().toString().trim(),
                        nim_input.getText().toString().trim(),
                        ipk_input.getText().toString().trim(),
                        course_input.getText().toString().trim()
                );
            }
        });
    }
}
