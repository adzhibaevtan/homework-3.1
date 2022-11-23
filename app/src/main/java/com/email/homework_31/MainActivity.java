package com.email.homework_31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    private Button nextSend;
    private EditText recipient, subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextSend = findViewById(R.id.send);
        recipient = findViewById(R.id.email);
        subject = findViewById(R.id.theme);
        message = findViewById(R.id.message);

        nextSend.setOnClickListener(view -> {
            composeEmail(recipient.getText().toString(), subject.getText().toString(), message.getText().toString());
        });
    }

    public void composeEmail(String recipient, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }
}