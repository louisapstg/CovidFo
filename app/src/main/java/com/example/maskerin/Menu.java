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

public class Menu extends AppCompatActivity {

    Button BtnMasker, BtnDonasi, BtnAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String USER = intent.getStringExtra("USER");

        BtnMasker = (Button) findViewById(R.id.btnMasker);
        BtnMasker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ListMasker.class);
                startActivity(intent);
            }
        });

        BtnDonasi = (Button) findViewById(R.id.btnDonasi);
        BtnDonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Donasi.class);
                intent.putExtra("USER", USER);
                startActivity(intent);
            }
        });

        BtnAkun = (Button) findViewById(R.id.btnAkun);
        BtnAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Akun.class);
                intent.putExtra("USER", USER);
                startActivity(intent);
            }
        });
    }


}