package com.example.maskerin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maskerin.DatabaseHelper.LoginDB;

public class Register extends AppCompatActivity {

    EditText etuser, etpassword, etconfpass;
    Button btndaftar, btnlogin;
    LoginDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new LoginDB(this);
        etuser = (EditText) findViewById(R.id.username);
        etpassword = (EditText) findViewById(R.id.password);
        etconfpass = (EditText) findViewById(R.id.konfirmasiPassword);
        btndaftar = (Button) findViewById(R.id.btnDaftar);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginintent = new Intent(Register.this, MainActivity.class);
                startActivity(loginintent);
            }
        });

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etuser.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                String cnfpas = etconfpass.getText().toString().trim();
                Boolean res = db.checkusername(username);

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(Register.this, "Silahkan Isi Username dan Password", Toast.LENGTH_SHORT).show();
                }
                else if (res) {
                    Toast.makeText(Register.this, "Username Sudah Dipakai", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals(cnfpas)){
                    long val = db.addUser(username,password);
                    if (val > 0) {
                        Toast.makeText(Register.this, "Anda Telah Terdafar", Toast.LENGTH_SHORT).show();
                        Intent moveTologin =  new Intent(Register.this, MainActivity.class);
                        startActivity(moveTologin);
                    }
                    else {
                        Toast.makeText(Register.this, "Pendaftaran Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Register.this, "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}