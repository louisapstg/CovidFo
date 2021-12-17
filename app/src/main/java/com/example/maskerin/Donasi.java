package com.example.maskerin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.maskerin.DatabaseHelper.LoginDB;
import com.squareup.picasso.Picasso;

public class Donasi extends AppCompatActivity {

    LoginDB db;
    EditText donasi;
    Button btnBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);

        ImageButton image1 = findViewById(R.id.image1);
        ImageButton image2 = findViewById(R.id.image2);
        ImageButton image3 = findViewById(R.id.image3);

        String url1 = "https://i.ibb.co/dLpSXF4/pngfind-com-facebook-logopng-5572352.png";
        String url2 = "https://static.pedulisehat.id/img/nav/middle-logo.png";
        String url3 = "https://benihbaik.com/img/logo-putih-bb.png";

        Picasso.get().load(url1).into(image1);
        Picasso.get().load(url2).into(image2);
        Picasso.get().load(url3).into(image3);

        Intent intent = getIntent();
        String USER = intent.getStringExtra("USER");

        btnBayar = (Button) findViewById(R.id.btnBayar);
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentto = new Intent(Donasi.this, sukses.class);
                intentto.putExtra("USER", USER);
                startActivity(intentto);
            }
        });
    }


    public void openWebURL(View view) {
        String url = "";
        switch (view.getId()) {
            case R.id.image1:
                url = "https://kitabisa.com";
                break;
            case R.id.image2:
                url = "https://pedulisehat.id/";
                break;
            case R.id.image3:
                url = "https://benihbaik.com/";
                break;
        }

        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( url ) );
        startActivity( browse );
    }
}