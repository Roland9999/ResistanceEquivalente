package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {

    double result = 0.0, res = 0.0;
    TextView final_result;
    List<String> valuesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        valuesList = ResitancesValuesList.getValuesList();
        final_result = (TextView) findViewById(R.id.final_result);

        int circuitType = ChooseComplexType.getCircuitType();

        if (circuitType == 1) {
            for (int i = 0; i < valuesList.size(); i++){
                result += Double.valueOf(valuesList.get(i));
            }
            final_result.setText(String.valueOf(result));
        } else if (circuitType == 2){
            for (int i = 0; i < valuesList.size(); i++){
                res += 1.0 / Double.valueOf(valuesList.get(i));
            }
            result = 1.0 / res;
            final_result.setText(String.valueOf(result));
        }
    }

    public void callHome(View view){
        valuesList = new ArrayList<>(); //mise à jour de la liste de valeurs des résistances
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
