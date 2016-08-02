package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SimpleType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_type);
    }

    /**Calling Home */
    public void callHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
