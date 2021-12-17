package com.example.maskerin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maskerin.DatabaseHelper.LoginDB;

public class Akun extends AppCompatActivity {

    LoginDB db;
    Button btnUbahPassword, btnHapus;
    public static final String TABLE_NAME = "registeruser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        db = new LoginDB(this);
        Intent intent = getIntent();
        String USER = intent.getStringExtra("USER");
        TextView tampilUser = (TextView) findViewById(R.id.user);
        tampilUser.setText(USER);

        btnUbahPassword = (Button) findViewById(R.id.btnPassword);
        btnUbahPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Akun.this, ChangePassword.class);
                intent.putExtra("USER", USER);
                startActivity(intent);
            }
        });

        btnHapus = (Button) findViewById(R.id.btnHapus);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete(USER);
                Intent intent = new Intent(Akun.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent_about = new Intent(this, About.class);
                startActivity(intent_about);
                return true;
            case R.id.action_exit:
                final AlertDialog.Builder tutup = new AlertDialog.Builder(this);
                tutup.setMessage("Apakah anda benar benar ingin keluar?")
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which){
                            }
                        })
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Akun.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }).create().show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}