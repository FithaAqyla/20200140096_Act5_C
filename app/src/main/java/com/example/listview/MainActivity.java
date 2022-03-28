package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name, et_password;
    Button login;
    String name,password;
    String isiName = "AQYLA";
    String isiPassword = "ananana";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_name = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });

    }

    private void validasi() {
        name = et_name.getText().toString();
        password = et_password.getText().toString();

        if(name.isEmpty()){
            et_name.setError("Username Diperlukan");
        }
        else if(password.isEmpty()){
            et_password.setError("Password Diperlukan");
        }
        else{
            if(!name.equals(isiName) && !password.equals(isiPassword)){
                Toast  toast= Toast.makeText(getApplicationContext(),
                        "Username dan Password Salah ", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0, 0);
                toast.show();
            }
            else if(!name.equals(isiName)){
                Toast  toast= Toast.makeText(getApplicationContext(),
                        "Nama Salah ", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0, 0);
                toast.show();
            }
            else if(!password.equals(isiPassword)){
                Toast  toast= Toast.makeText(getApplicationContext(),
                        "Password Salah ", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0, 0);
                toast.show();
            }
            else{
                Bundle b = new Bundle();
                b.putString("a", name.trim());

                Intent i = new Intent(getApplicationContext(), Home.class);
                i.putExtras(b);
                startActivity(i);
                Toast toast= Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);

                toast.show();

                et_name.getText().clear();
                et_password.getText().clear();
            }
        }
    }
}