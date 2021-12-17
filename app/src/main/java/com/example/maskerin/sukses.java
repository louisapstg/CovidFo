package com.example.maskerin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class sukses extends AppCompatActivity {

    Button goPesan, goToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sukses);

        Intent intent = getIntent();
        String USER = intent.getStringExtra("USER");

        goToMenu            = (Button) findViewById(R.id.to_menu);
        goPesan		        = (Button)findViewById(R.id.btnPesan);

        goPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i;
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://api.whatsapp.com/send?phone="+"+6281226336958"+"&text=Saya ingin melakukan pembayaran.."));
                startActivity(i);


            }
        });

        goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sukses.this, Menu.class);
                intent.putExtra("USER", USER);
                startActivity(intent);
            }
        });
    }
}