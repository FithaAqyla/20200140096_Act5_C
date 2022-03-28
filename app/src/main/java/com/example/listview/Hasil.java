package com.example.listview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hasil extends AppCompatActivity {
    TextView Nama, NoHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Nama = findViewById(R.id.tf_nama);
        NoHp = findViewById(R.id.tf_nohp);

        Bundle b = getIntent().getExtras();
        String nama = b.getString("a");

        switch (nama){
            case "Aqyla":
                Nama.setText("Aqyla");
                NoHp.setText("11111");
                break;
            case "Fitha":
                Nama.setText("Fitha");
                NoHp.setText("22222");
                break;
            case "Nafisah":
                Nama.setText("Nafisah");
                NoHp.setText("3333333");
                break;
        }
    }
}
