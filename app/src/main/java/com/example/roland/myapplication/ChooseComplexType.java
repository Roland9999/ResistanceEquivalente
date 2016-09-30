package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseComplexType extends AppCompatActivity {

    private static int circuitType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_complex_type);
    }

    /**
     * Calling activity ChooseNbr
     */
    public void callChooseNbr(View view) {

        switch (view.getId()) {
            case R.id.serial_type_button:
                setCircuitType(1);
                Intent intent = new Intent(this, ChooseNbr.class);
                this.startActivity(intent);
                break;
            case R.id.parallel_type_button:
                setCircuitType(2);
                Intent intent2 = new Intent(this, ChooseNbr.class);
                this.startActivity(intent2);
                break;
        }
    }


    /**
     * Calling Home
     */
    public void callHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    public static int getCircuitType() {
        return circuitType;
    }

    public static void setCircuitType(int circuitType) {
        ChooseComplexType.circuitType = circuitType;
    }
}
