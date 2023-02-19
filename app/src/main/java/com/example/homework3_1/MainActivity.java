package com.example.homework3_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText gMail = findViewById(R.id.et_email);
        EditText theme = findViewById(R.id.et_subject);
        EditText sms = findViewById(R.id.et_text);
        Button send = findViewById(R.id.btn_send);

        send.setOnClickListener(view -> sendEmail(gMail.getText().toString(), theme.getText().toString(), sms.getText().toString()));
    }

    private void sendEmail(String email, String theme, String sms) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, theme);
        intent.putExtra(Intent.EXTRA_TEXT, sms);

        startActivity(intent);
    }
}