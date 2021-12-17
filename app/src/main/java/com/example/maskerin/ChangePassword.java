package com.example.maskerin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maskerin.DatabaseHelper.LoginDB;

public class ChangePassword extends AppCompatActivity {

    String pass, confpass;
    EditText etpassword, etconfpass;
    Button btnUbahPassword;
    LoginDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Intent intent = getIntent();
        String USER = intent.getStringExtra("USER");

        db = new LoginDB(this);
        etpassword = (EditText) findViewById(R.id.password);
        etconfpass = (EditText) findViewById(R.id.konfirmasiPassword);
        btnUbahPassword = (Button) findViewById(R.id.btnUbahPassword);
        btnUbahPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = etpassword.getText().toString();
                confpass = etconfpass.getText().toString();

                if (pass.equals("") || confpass.equals("")) {
                    Toast.makeText(ChangePassword.this, "Silahkan Isi Username dan Password", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(confpass)) {
                    db.updatedata(USER, pass);
                    Intent intent = new Intent(ChangePassword.this, Akun.class);
                    intent.putExtra("USER", USER);
                    startActivity(intent);
                }
            }
        });
    }
}