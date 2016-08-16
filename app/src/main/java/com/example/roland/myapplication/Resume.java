package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Resume extends AppCompatActivity {

    List<String> valuesList = ResitancesValuesList.getValuesList();
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        myListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, valuesList);
        myListView.setAdapter(adapter);

        //int val = ChooseComplexType.getCircuitType();
    }

    /**Calling activity AddAResistance */
    public void callResultPage(View view){
        Intent intent  = new Intent(this, Result.class);
        this.startActivity(intent);
    }

    public void callHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
