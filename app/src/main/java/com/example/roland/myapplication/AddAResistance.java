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
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //appel d'une classe abstraite entraîne les deux fonctions ci-dessous
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nbRings((Spinner) parent);
                int nb = Resistance.getNbAnneaux();
                switch (nb){
                    case 3: //for resitance with 3 rings
                        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner2);
                        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner3);
                        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4); //multiplier
                        takingSpinnerValueRes3Rings_2(spinner4);
                        break;
                    case 4: //for resitance with 4 rings
                        Spinner spinner22 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner22);
                        Spinner spinner33 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner33);
                        Spinner spinner44 = (Spinner) findViewById(R.id.spinner4); //multiplier
                        takingSpinnerValueRes3Rings_2(spinner44);
                        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5); //tolerance
                        takingSpinnerValueRes4Rings_0(spinner5);
                        break;
                    case 5: //for resitance with 5 rings
                        Spinner spinner222 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner222);
                        Spinner spinner333 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner333);
                        Spinner spinner444 = (Spinner) findViewById(R.id.spinner4);
                        takingSpinnerValueRes3Rings_3(spinner444);
                        Spinner spinner55 = (Spinner) findViewById(R.id.spinner5); //multiplier
                        takingSpinnerValueRes4Rings_1(spinner55);
                        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6); //tolerance
                        takingSpinnerValueRes5Rings(spinner6);
                        break;
                    case 6: //for resitance with 6 rings
                        Spinner spinner2222 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner2222);
                        Spinner spinner3333 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner3333);
                        Spinner spinner4444 = (Spinner) findViewById(R.id.spinner4);
                        takingSpinnerValueRes3Rings_3(spinner4444);
                        Spinner spinner555 = (Spinner) findViewById(R.id.spinner5); //multiplier
                        takingSpinnerValueRes4Rings_1(spinner555);
                        Spinner spinner66 = (Spinner) findViewById(R.id.spinner6); //tolerance
                        takingSpinnerValueRes5Rings(spinner66);
                        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
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

    /**Calling Home */
    public void callHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    /**setting nomber of ring of a resistance*/
    public void nbRings(Spinner spinner){
        int spinner_pos = spinner.getSelectedItemPosition();
        String[] ringsNb = getResources().getStringArray(R.array.nb);
        int nbAnneaux = Integer.valueOf(ringsNb[spinner_pos]);
        Resistance.setNbAnneaux(nbAnneaux);
    }

    /**evaluating value of a resistance with 3 rings*/
    public double evaluationResVal3Rings(){
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal3());
        return computeValue(R.getNbAnneaux(), R.getTabDouble());
    }

    /**evaluating value of a resistance with 4 rings*/
    public double evaluationResVal4Rings(){
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal3(), Resistance.getVal4());
        return computeValue2(R.getNbAnneaux(), R.getTabDouble());
    }

    public double computeValue(int nbAnneaux, double[] tabDouble){
        int soustracteur = 2;
        if (nbAnneaux == 4) soustracteur = 3;
        return  (tabDouble[0]*Math.pow(10,(nbAnneaux-soustracteur))+
                 tabDouble[1]*Math.pow(10,(nbAnneaux-(soustracteur + 1))))*Math.pow(10,tabDouble[2]);
    }

    public double computeValue2(int nbAnneaux, double[] tabDouble){
        int soustracteur = 3;
        if (nbAnneaux == 6) soustracteur = 4;
        return  (tabDouble[0]*Math.pow(10,(nbAnneaux-soustracteur))+
                 tabDouble[1]*Math.pow(10,(nbAnneaux-(soustracteur + 1)))+
                 tabDouble[2]*Math.pow(10,(nbAnneaux-(soustracteur + 2))))*Math.pow(10,tabDouble[3]);
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

    public void takingSpinnerValueRes3Rings_2(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsMultiplierValues.ringsMultiplierColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal3(ColorsMultiplierValues.getMultiplierColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal3Rings();
                Resistance.setValResistance(value);
                TextView total = (TextView)findViewById(R.id.total);
                total.setText(String.valueOf(value));

                TextView tolerance = (TextView)findViewById(R.id.tolerance);
                tolerance.setText(" 20 % ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal3(0.0);
            }
        });
    }

    public void takingSpinnerValueRes3Rings_3(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    public void takingSpinnerValueRes4Rings_0(Spinner spinner){
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsToleranceValues.ringsToleranceColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal4(ColorsToleranceValues.getToleranceColorsValue().get(parent.getSelectedItem().toString()));

                TextView tolerance = (TextView)findViewById(R.id.tolerance);
                tolerance.setText( String.valueOf(Resistance.getVal4())+" % ");
              }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal4(0.0);
            }
        });
    }

    public void takingSpinnerValueRes4Rings_1(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsMultiplierValues.ringsMultiplierColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal4(ColorsMultiplierValues.getMultiplierColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal4Rings();
                Resistance.setValResistance(value);
                TextView total = (TextView) findViewById(R.id.total);
                total.setText(String.valueOf(value));
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
                Resistance.setVal5(ColorsToleranceValues.getToleranceColorsValue().get(parent.getSelectedItem().toString()));

                TextView tolerance = (TextView)findViewById(R.id.tolerance);
                tolerance.setText( String.valueOf(Resistance.getVal5())+" % ");
             }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal5(0.0);
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
                Resistance.setVal6(ColorsTemperatureCoefficientValues.getTemperatureCoefficientColorsValue().get(parent.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal6(0.0);
            }
        });
    }
}
