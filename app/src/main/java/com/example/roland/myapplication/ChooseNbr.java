package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class ChooseNbr extends AppCompatActivity {


    public final static String userChoice = "com.example.roland.myapplication.userChoice";

    private String nbrResistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_nbr);
        EditText editText = (EditText) findViewById(R.id.enter_number);
        //create a variable for save the number written by the user.
        setNbrResistance(editText.getText().toString());
        String enterNbrResist = getNbrResistance();
        //Integer nbrResInteger = Integer.parseInt(enterNbrResist); //impossible de convertire correctemennt la variable en int, cela fait buguer l'application
        Intent nbrResistanceSelected = new Intent();
        nbrResistanceSelected.putExtra(ChooseNbr.userChoice, enterNbrResist);
    }


    public void onValidate(View view) {
        Intent intent = new Intent(this, MultiAddAResistance.class);
        this.startActivity(intent);
    }


    /**
     * Calling Home
     */
    public void callHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    public String getNbrResistance() {
        return nbrResistance;
    }

    public void setNbrResistance(String nbrResistance) {
        this.nbrResistance = nbrResistance;
    }

}
