package com.example.maskerin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListMasker extends AppCompatActivity {

    final String[] judul = {
            "HKS Masker KN95 ORIGINAL TOP QUALITY 5 STAR", "Masker 3 lapis / 50 pcs",
            "Masker scuba polos dewasa", "Masker Kriwil Flowsy",
            "Indoshare Masker Headloop 3ply untuk Hijab ", "Masker KN95 Original i-care",
            "Disposable Protective Mask Earloop 3 PLY H113", "KN95 MASKER DISPOSABLE GRADE C",
            "MASKER KPOP ALA KOREA", "Goto Enviro Masker Earloop Kesehatan"
    };
    final String[] harga = {
            "Rp 5.100", "Rp 19.000", "Rp 1.500", "Rp 7.000", "Rp 21.900", "Rp 13.500", "Rp 335.000",
            "Rp 2.100", "Rp 149.000", "Rp 1.990"
    };
    final int[] gambar = {
            R.drawable.masker1, R.drawable.masker2, R.drawable.masker3, R.drawable.masker4,
            R.drawable.masker5, R.drawable.masker6, R.drawable.masker7, R.drawable.masker8,
            R.drawable.masker9, R.drawable.masker10
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_masker2);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ListView listView = findViewById(R.id.list_view);
        ArrayList<HashMap<String, String>> arrayList
                = new ArrayList<>();

        for (int i = 0; i < judul.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("judul", judul[i]);
            hashMap.put("harga", harga[i]);
            hashMap.put("gambar", Integer.toString(gambar[i]));
            arrayList.add(hashMap);
        }

        String[] from = {"gambar","judul", "harga"};
        int[] to = {R.id.gambarMasker,R.id.judul, R.id.harga};
        SimpleAdapter adapter = new SimpleAdapter(
                this, arrayList,
                R.layout.list_masker,
                from, to
        );
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        String USER = intent.getStringExtra("USER");


    }

    public void goToPembayaran(View view) {
        Intent intent = new Intent(this, Pembayaran.class);
        startActivity(intent);
    }

}