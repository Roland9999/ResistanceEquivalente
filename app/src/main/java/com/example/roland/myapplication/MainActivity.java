package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**Calling activity AddAResistance */
    public void callAddAResistance(View view){
        Intent intent  = new Intent(this, AddAResistance.class);
        this.startActivity(intent);
    }

}
