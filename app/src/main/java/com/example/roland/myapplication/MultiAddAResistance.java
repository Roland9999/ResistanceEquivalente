package com.example.roland.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MultiAddAResistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_add_aresistance);
        Bundle b = getIntent().getExtras();
        int nbrResInteger = b.getInt("userChoise");
        //int compter = compter + 1;
        //int nbrResInteger = 3;
        int compter = 1;
        TextView nbrResistanceSelected = (TextView) findViewById(R.id.affiche_nbr_resistance);
        nbrResistanceSelected.setText(String.valueOf(nbrResInteger));
        TextView nbrResistanceAlreadyEnter = (TextView) findViewById(R.id.number_already_enter);
        nbrResistanceAlreadyEnter.setText(String.valueOf(compter));

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
                int nb = Resistance.getNbAnneaux();
                switch (nb) {
                    case 3: //for resitance with 3 rings
                        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner2);
                        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner3);
                        Spinner spinner4 = (Spinner) findViewById(R.id.spinner5);
                        takingSpinnerValueRes4Rings(spinner4);
                        break;
                    case 4: //for resitance with 4 rings
                        Spinner spinner22 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner22);
                        Spinner spinner33 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner33);
                        Spinner spinner44 = (Spinner) findViewById(R.id.spinner5);
                        takingSpinnerValueRes4Rings(spinner44);
                        Spinner spinner5 = (Spinner) findViewById(R.id.spinner6);
                        takingSpinnerValueRes5Rings(spinner5);
                        break;
                    case 5: //for resitance with 5 rings
                        Spinner spinner222 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner222);
                        Spinner spinner333 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner333);
                        Spinner spinner444 = (Spinner) findViewById(R.id.spinner4);
                        takingSpinnerValueRes3Rings_2(spinner444);
                        Spinner spinner55 = (Spinner) findViewById(R.id.spinner5);
                        takingSpinnerValueRes4Rings(spinner55);
                        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
                        takingSpinnerValueRes5Rings(spinner6);
                        break;
                    case 6: //for resitance with 6 rings
                        Spinner spinner2222 = (Spinner) findViewById(R.id.spinner2);
                        takingSpinnerValueRes3Rings(spinner2222);
                        Spinner spinner3333 = (Spinner) findViewById(R.id.spinner3);
                        takingSpinnerValueRes3Rings_1(spinner3333);
                        Spinner spinner4444 = (Spinner) findViewById(R.id.spinner4);
                        takingSpinnerValueRes3Rings_2(spinner4444);
                        Spinner spinner555 = (Spinner) findViewById(R.id.spinner5);
                        takingSpinnerValueRes4Rings(spinner555);
                        Spinner spinner66 = (Spinner) findViewById(R.id.spinner6);
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
    }

    /**
     * Next botton call new same page or result page
     */
    public void callNext(View view) {
        int nbrResInteger = 2;
        int compter = 1;
        if (compter < nbrResInteger) {
            Intent intent = new Intent(this, MultiAddAResistance.class);
            this.startActivity(intent);
        } else {
            Intent intent = new Intent(this, Result.class);
            this.startActivity(intent);
        }
    }

    /**
     * Calling Home
     */
    public void callHome(View view) {
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

    /**setting value of variable val*/
/*    public void setVal(String color){
        Map<String, Integer> colorsValues = ColorsValue.getColorsValue();
        Resistance.setVal((double) colorsValues.get(color));
    }
*/

    /**
     * evaluating value of a resistance with 3 rings
     */
    public double evaluationResVal3Rings() {
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal4());
        return computeValue(R.getNbAnneaux(), R.getTabDouble());
    }

    /**
     * evaluating value of a resistance with 4 rings
     */
    public double evaluationResVal4Rings() {
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal4());
        return computeValue(R.getNbAnneaux(), R.getTabDouble());
    }

    /**
     * evaluating value of a resistance with 5 rings
     */
    public double evaluationResVal5Rings() {
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal3(), Resistance.getVal4());
        return computeValue(R.getNbAnneaux(), R.getTabDouble());
    }

    /**
     * evaluating value of a resistance with 6 rings
     */
    public double evaluationResVal6Rings() {
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal3(), Resistance.getVal4());
        return computeValue(R.getNbAnneaux(), R.getTabDouble());
    }


    public double computeValue(int nbAnneaux, double[] tabDouble) {
        int soustracteur = 2;
        if (nbAnneaux == 4) soustracteur = 3;
        if (nbAnneaux == 5) soustracteur = 3;
        if (nbAnneaux == 6) soustracteur = 4;
        return ((tabDouble[0] * Math.pow(10.0, (nbAnneaux - soustracteur))) +
                (tabDouble[1] * Math.pow(10.0, (nbAnneaux - (soustracteur + 1)))) +
                (tabDouble[2] * Math.pow(10.0, (nbAnneaux - (soustracteur + 2))))) * Math.pow(10.0, tabDouble[3]); // j'ai ré-inversé l'indice 2 et 3 car j'ai rajouté une valeur par défaut de 0 à l'indice 2 lorsqu'il ya moins de 5 anneaux.
    }

    /**
     *
     */
    public void takingSpinnerValueRes3Rings(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal((double) ColorsValue.getColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal3Rings();
                TextView total = (TextView) findViewById(R.id.total);
                total.setText(String.valueOf(value));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }

    public void takingSpinnerValueRes3Rings_1(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal2((double) ColorsValue.getColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal3Rings();
                TextView total = (TextView) findViewById(R.id.total);
                total.setText(String.valueOf(value));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }

    public void takingSpinnerValueRes3Rings_2(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsValue.ringsColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal3((double) ColorsValue.getColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal3Rings();
                TextView total = (TextView) findViewById(R.id.total);
                total.setText(String.valueOf(value));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }

    public void takingSpinnerValueRes4Rings(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsMultiplierValues.ringsMultiplierColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal4((double) ColorsMultiplierValues.getMultiplierColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal4Rings();
                TextView total = (TextView) findViewById(R.id.total);
                total.setText(String.valueOf(value));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }

    public void takingSpinnerValueRes5Rings(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsToleranceValues.ringsToleranceColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal5((double) ColorsToleranceValues.getToleranceColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal5Rings();
                TextView total = (TextView) findViewById(R.id.total);
                total.setText(String.valueOf(value));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }

    public void takingSpinnerValueRes6Rings(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsTemperatureCoefficientValues.ringsTemperatureCoefficientColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal6((double) ColorsTemperatureCoefficientValues.getTemperatureCoefficientColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal6Rings();
                TextView total = (TextView) findViewById(R.id.total);
                total.setText(String.valueOf(value));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal(0.0);
            }
        });
    }


}
