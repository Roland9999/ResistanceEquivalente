package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

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
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //calling abstract class
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nbRings((Spinner) parent);
                int nb = Resistance.getNbAnneaux();
                Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
                Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
                Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
                Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
                Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
                Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
                switch (nb) {
                    case 3: //for resistance with 3 rings
                        spinner5.setVisibility(View.GONE);
                        spinner6.setVisibility(View.GONE);
                        spinner7.setVisibility(View.GONE);
                        takingSpinnerValueRes3Rings(spinner2);
                        takingSpinnerValueRes3Rings_1(spinner3);
                        takingSpinnerValueRes3Rings_2(spinner4);
                        break;
                    case 4: //for resistance with 4 rings
                        spinner5.setVisibility(View.VISIBLE);
                        spinner6.setVisibility(View.GONE);
                        spinner7.setVisibility(View.GONE);
                        takingSpinnerValueRes3Rings(spinner2);
                        takingSpinnerValueRes3Rings_1(spinner3);
                        takingSpinnerValueRes3Rings_2(spinner4);
                        takingSpinnerValueRes5Rings(spinner5);
                        break;
                    case 5: //for resistance with 5 rings
                        spinner5.setVisibility(View.VISIBLE);
                        spinner6.setVisibility(View.VISIBLE);
                        spinner7.setVisibility(View.GONE);
                        takingSpinnerValueRes3Rings(spinner2);
                        takingSpinnerValueRes3Rings_1(spinner3);
                        takingSpinnerValueRes3Rings_3(spinner4);
                        takingSpinnerValueRes3Rings_2(spinner5);
                        takingSpinnerValueRes5Rings(spinner6);
                        break;
                    case 6: //for resistance with 6 rings
                        spinner5.setVisibility(View.VISIBLE);
                        spinner6.setVisibility(View.VISIBLE);
                        spinner7.setVisibility(View.VISIBLE);
                        takingSpinnerValueRes3Rings(spinner2);
                        takingSpinnerValueRes3Rings_1(spinner3);
                        takingSpinnerValueRes3Rings_3(spinner4);
                        takingSpinnerValueRes3Rings_2(spinner5);
                        takingSpinnerValueRes5Rings(spinner6);
                        takingSpinnerValueRes6Rings(spinner7);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setNbAnneaux(3);
            }
        });

        nbRings(spinner);
    }

    /**
     * Calling Home
     */
    public void callHome(View view){
        Resistance.setVal(0.0);
        Resistance.setVal2(0.0);
        Resistance.setVal3(0.0);
        Resistance.setVal4(0.0);
        Resistance.setVal5(20.0);
        Resistance.setVal6(0.0);
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    /**
     * setting nomber of ring of a resistance
     */
    public void nbRings(Spinner spinner) {
        int spinner_pos = spinner.getSelectedItemPosition();
        String[] ringsNb = getResources().getStringArray(R.array.nb);
        int nbAnneaux = Integer.valueOf(ringsNb[spinner_pos]);
        Resistance.setNbAnneaux(nbAnneaux);
    }

    /**evaluating value of a resistance with 6 rings*/
    public double evaluationResVal6Rings(){
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal3(), Resistance.getVal4());
        return computeValue(R.getNbAnneaux(), R.getTabDouble());
    }

    public double computeValue(int nbAnneaux, double[] tabDouble){
        int soustracteur = 2;
        if (nbAnneaux == 4) soustracteur = 3;
        if (nbAnneaux == 5) soustracteur = 3;
        if (nbAnneaux == 6) soustracteur = 4;
        return  ((tabDouble[0]*Math.pow(10.0,(nbAnneaux-soustracteur)))+
                (tabDouble[1]*Math.pow(10.0,(nbAnneaux-(soustracteur + 1))))+
                (tabDouble[2]*Math.pow(10.0,(nbAnneaux-(soustracteur + 2)))))*Math.pow(10.0,tabDouble[3]); // j'ai ré-inversé l'indice 2 et 3 car j'ai rajouté une valeur par défaut de 0 à l'indice 2 lorsqu'il ya moins de 5 anneaux.
    }

    /**
     *
     */
    public void takingSpinnerValueRes3Rings(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal((double) ColorsValue.getColorsValue().get(parent.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }

    public void takingSpinnerValueRes3Rings_1(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal2((double) ColorsValue.getColorsValue().get(parent.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal2(0.0);
            }
        });
    }

    public void takingSpinnerValueRes3Rings_3(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal3((double) ColorsValue.getColorsValue().get(parent.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal3(0.0);
            }
        });
    }

    public void takingSpinnerValueRes3Rings_2(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsMultiplierValues.ringsMultiplierColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal4((double) ColorsMultiplierValues.getMultiplierColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal6Rings();
                TextView total = (TextView)findViewById(R.id.total);
                total.setText(String.valueOf(value));

                Resistance.setVal5(20.0);
                TextView tolerance = (TextView)findViewById(R.id.tolerance);
                tolerance.setText( String.valueOf(Resistance.getVal5())+" % ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal4(0.0);
            }
        });
    }

    public void takingSpinnerValueRes5Rings(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsToleranceValues.ringsToleranceColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal5((double) ColorsToleranceValues.getToleranceColorsValue().get(parent.getSelectedItem().toString()));

                TextView tolerance = (TextView)findViewById(R.id.tolerance);
                tolerance.setText(String.valueOf(Resistance.getVal5())+" % ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal5(20.0);
                TextView tolerance = (TextView)findViewById(R.id.tolerance);
                tolerance.setText( String.valueOf(Resistance.getVal5())+" % ");
            }
        });
    }

    public void takingSpinnerValueRes6Rings(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsTemperatureCoefficientValues.ringsTemperatureCoefficientColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal6((double) ColorsTemperatureCoefficientValues.getTemperatureCoefficientColorsValue().get(parent.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }
}
