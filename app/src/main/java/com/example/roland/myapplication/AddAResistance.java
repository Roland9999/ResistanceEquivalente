package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AddAResistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aresistance);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nb, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        //int val = Integer.parseInt(spinner.getSelectedItem().toString()); //to get the entry
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //appel d'une classe abstraite entraîne les deux fonctions ci-dessous
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nbRings((Spinner) parent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setNbAnneaux(3);
            }
        });

        nbRings(spinner);
        /*
        TextView total = (TextView)findViewById(R.id.total);
        total.setText(String.valueOf(nbAnneaux));
        Resistance.setNbAnneaux(nbAnneaux);
        */
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        CostomSpinnerAdapter adapter2 = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        // Create an ArrayAdapter using the string array and a default spinner layout
        CostomSpinnerAdapter adapter3 = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner3.setAdapter(adapter3);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        // Create an ArrayAdapter using the string array and a default spinner layout
        CostomSpinnerAdapter adapter4 = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner4.setAdapter(adapter4);

        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        // Create an ArrayAdapter using the string array and a default spinner layout
        CostomSpinnerAdapter adapter5 = new CostomSpinnerAdapter(this, ColorsMultiplierValues.ringsMultiplierColors());
        // Specify the layout to use when the list of choices appears
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner5.setAdapter(adapter5);

        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        // Create an ArrayAdapter using the string array and a default spinner layout
        /*ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this,
                R.array.colors, android.R.layout.simple_spinner_item);*/
        CostomSpinnerAdapter adapter6 = new CostomSpinnerAdapter(this, ColorsToleranceValues.ringsToleranceColors());
        // Specify the layout to use when the list of choices appears
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner6.setAdapter(adapter6);

        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        // Create an ArrayAdapter using the string array and a default spinner layout
        /*ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this,
                R.array.colors, android.R.layout.simple_spinner_item);*/
        CostomSpinnerAdapter adapter7 = new CostomSpinnerAdapter(this, ColorsTemperatureCoefficientValues.ringsTemperatureCoefficientColors());
        // Specify the layout to use when the list of choices appears
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner7.setAdapter(adapter7);
    }

    /**Calling Home */
    public void callHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    /**setting nomber of ring of a resistanc*/
    public void nbRings(Spinner spinner){
        int spinner_pos = spinner.getSelectedItemPosition();
        String[] ringsNb = getResources().getStringArray(R.array.nb);
        int nbAnneaux = Integer.valueOf(ringsNb[spinner_pos]);
        Resistance.setNbAnneaux(nbAnneaux);
    }

}
