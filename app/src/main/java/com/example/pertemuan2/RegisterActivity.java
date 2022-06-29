package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button register, toLogin;
    EditText registerUsername, registerName, registerPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.btn_register);
        toLogin = findViewById(R.id.btn_toLogin);
        registerUsername = findViewById(R.id.et_registerUsername);
        registerName = findViewById(R.id.et_registerName);
        registerPassword = findViewById(R.id.et_registerPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        register.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString( "account_username", registerUsername.getText().toString());
            editor.putString( "account_name", registerName.getText().toString());
            editor.putString( "account_password", registerPassword.getText().toString());
            editor.apply();

            Toast.makeText(RegisterActivity.this,"Register Success, go to Login Activity!", Toast.LENGTH_SHORT).show();

        });

        toLogin.setOnClickListener(view -> {
            Intent toLoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(toLoginIntent);
        });
    }
}