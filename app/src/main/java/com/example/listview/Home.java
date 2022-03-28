package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private android.widget.ListView list;
    private ListViewAdapter adapter;
    String[] ListNama;
    public static ArrayList<ClassName>classNamaArrayList=new ArrayList<>();

    Bundle bundle = new Bundle();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListNama = new String[]{"Aqyla", "Fitha", "Nafisah"};

        list = findViewById(R.id.listkontak);
        classNamaArrayList = new ArrayList<>();

        for(int i = 0; i <ListNama.length; i++){
            ClassName classnama = new ClassName(ListNama[i]);
            classNamaArrayList.add(classnama);
        }
        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new  AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
                String nama = classNamaArrayList.get(position).getNama();
                bundle.putString("a", nama.trim());
                PopupMenu mn = new PopupMenu(getApplicationContext(),view);

                mn.setOnMenuItemClickListener(Home.this);

                mn.inflate(R.menu.popup_menu);
                mn.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), Hasil.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini Untuk Edit", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnhps:
                Toast.makeText(getApplicationContext(),"Ini Untuk Hapus", Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture){

    }
}
