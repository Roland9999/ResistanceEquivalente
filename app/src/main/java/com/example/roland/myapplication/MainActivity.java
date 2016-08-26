package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
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

    /**Calling activity ChooseComplexType */
    public void callChooseComplexType(View view){
        Intent intent  = new Intent(this, ChooseComplexType.class);
        this.startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Récupération de l'orientation de l'écran
        int rotationEcran = this.getWindowManager().getDefaultDisplay().getRotation();

        // Et positionner ainsi le nombre de degrés de rotation
        int degrees = 0;
        switch (rotationEcran) {
            case Surface.ROTATION_0: degrees = 0;
                break;
            case Surface.ROTATION_90: degrees = 90;
                break;
            case Surface.ROTATION_180: degrees = 180;
                break;
            case Surface.ROTATION_270: degrees = 270;
                break;
        }

        Log.d ("test orientation", "=" + degrees);
    }
}
