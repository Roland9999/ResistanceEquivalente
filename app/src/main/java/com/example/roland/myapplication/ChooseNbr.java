package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class ChooseNbr extends AppCompatActivity {

    private int nbRes;
    private EditText editText;
    private String nbResistances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_nbr);

        editText = (EditText) findViewById(R.id.enter_number);
        editText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                nbResistances = editText.getText().toString().intern();
                try {
                    setNbRes(Integer.parseInt(nbResistances));
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe + " in integer");
                }
            }
        });

    }


    /**Calling Home */
    public void callHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    /**validation of the number of resistances*/
    public void validationNbRes(View v){
        Intent intent = new Intent(this, ListOfResistances.class);
        intent.putExtra("remainingLoops", getNbRes()); //passage en boucle de l'activité getNbRes() fois
        startActivity(intent);
    }

    public int getNbRes() {
        return nbRes;
    }

    public void setNbRes(int nbRes) {
        this.nbRes = nbRes;
    }
}
