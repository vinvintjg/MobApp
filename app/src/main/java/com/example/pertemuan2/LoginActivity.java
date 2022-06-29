package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login, toRegister;
    EditText loginUsername, loginPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btn_login);
        toRegister = findViewById(R.id.btn_toRegister);
        loginUsername=findViewById(R.id.et_loginUsername);
        loginPassword= findViewById(R.id.et_loginPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        login.setOnClickListener(view -> {
            if(!loginUsername.getText().toString().equals(sharedPref.getString("account_username", ""))){
                Toast.makeText(LoginActivity.this, "Username invalid", Toast.LENGTH_SHORT).show();
            }else if(!loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))){
                Toast.makeText(LoginActivity.this, "Password invalid", Toast.LENGTH_SHORT).show();
            }else if(loginUsername.getText().toString().equals(sharedPref.getString("account_username", ""))
                    && loginPassword.getText().toString().equals(sharedPref.getString("account_password", ""))) {
                Intent loginIntent = new Intent(LoginActivity.this, MainAc.class);
                loginIntent.putExtra("account_username", sharedPref.getString("account_username", ""));
                startActivity(loginIntent);
            }
        });

        toRegister.setOnClickListener(v -> {
            Intent toRegisterIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(toRegisterIntent);
        });
    }
}