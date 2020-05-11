package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText etEmail,etConfirm,etType;
    TextView tvName,tvEnd;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvName = findViewById(R.id.tvName);
        etEmail = findViewById(R.id.etEmail);
        etConfirm = findViewById(R.id.etConfirm);
        etType = findViewById(R.id.etType);
        btnRegister = findViewById(R.id.btnRegister);
        tvEnd = findViewById(R.id.tvEnd);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEmail.getText().toString().isEmpty() || etConfirm.getText().toString().isEmpty() || etType.getText().toString().isEmpty())
                {
                    Toast.makeText(register.this, "Please enter all details!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (etType.getText().toString().equals(etConfirm.getText().toString()))
                    {

                    }
                    else
                    {
                        Toast.makeText(register.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        String text = findViewById(tvEnd);

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.RED);
            }
        };

        ss.setSpan(clickableSpan1,24,29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvEnd.setText(ss);
        tvEnd.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
