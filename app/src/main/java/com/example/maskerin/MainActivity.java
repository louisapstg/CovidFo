package com.example.maskerin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maskerin.DatabaseHelper.LoginDB;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    EditText etuser, etpassword;
    Button BtnDaftar, BtnLogin;
    LoginDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new LoginDB(this);
        etuser = (EditText) findViewById(R.id.username);
        etpassword = (EditText) findViewById(R.id.password);
        BtnLogin = (Button) findViewById(R.id.btnLogin);
        BtnDaftar = (Button) findViewById(R.id.btnDaftar);
        BtnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(MainActivity.this, Register.class);
                startActivity(registerintent);
            }
        });

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etuser.getText().toString().trim();
                String pwd = etpassword.getText().toString().trim();
                Boolean res = db.checkuser(user, pwd);
                if (res)
                {
                    Toast.makeText(MainActivity.this, "Login Berhasil!",Toast.LENGTH_SHORT).show();
                    Intent intentMoveToMain = new Intent(MainActivity.this, Menu.class);
                    intentMoveToMain.putExtra("USER", etuser.getText().toString());
                    startActivity(intentMoveToMain);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Gagal!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}