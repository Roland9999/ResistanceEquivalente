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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_nbr);
        EditText editText = (EditText) findViewById(R.id.enter_number);
        //create a variable for save the number written by the user.
        String nbrResistance = editText.getText().toString();
    }

    public void onValidate(View view) {

    }

   /* public void enterNbr(View view){
        //Intent editTextNbr = new Intent (android.inputmethodservice.ExtractEditText);

    }*/



    /**Calling Home */
    public void callHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
