package com.example.maskerin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.maskerin.DatabaseHelper.LoginDB;

public class Pembayaran extends AppCompatActivity {

    Button goToSukses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        Intent intent = getIntent();
        String USER = intent.getStringExtra("USER");

        goToSukses = (Button) findViewById(R.id.btnBayar);
        goToSukses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pembayaran.this, sukses.class);
                intent.putExtra("USER", USER);
                startActivity(intent);
            }
        });
    }
}

