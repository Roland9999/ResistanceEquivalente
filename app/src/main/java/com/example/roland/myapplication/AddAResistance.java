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
        if (spinner != null) {
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
                            settingVisibilityOfElements(nb);
                            takingSpinnerValueRes3Rings(spinner2);
                            takingSpinnerValueRes3Rings_1(spinner3);
                            takingSpinnerValueRes3Rings_2(spinner4);
                            break;
                        case 4: //for resistance with 4 rings
                            settingVisibilityOfElements(nb);
                            takingSpinnerValueRes3Rings(spinner2);
                            takingSpinnerValueRes3Rings_1(spinner3);
                            takingSpinnerValueRes3Rings_2(spinner4);
                            takingSpinnerValueRes4Rings_0(spinner5);
                            break;
                        case 5: //for resistance with 5 rings
                            settingVisibilityOfElements(nb);
                            takingSpinnerValueRes3Rings(spinner2);
                            takingSpinnerValueRes3Rings_1(spinner3);
                            takingSpinnerValueRes3Rings_3(spinner4);
                            takingSpinnerValueRes4Rings_1(spinner5);
                            takingSpinnerValueRes5Rings(spinner6);
                            break;
                        case 6: //for resistance with 6 rings
                            settingVisibilityOfElements(nb);
                            takingSpinnerValueRes3Rings(spinner2);
                            takingSpinnerValueRes3Rings_1(spinner3);
                            takingSpinnerValueRes3Rings_3(spinner4);
                            takingSpinnerValueRes4Rings_1(spinner5);
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
        }

        nbRings(spinner);
    }

    public void settingVisibilityOfElements(int a) {
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        Spinner spinner6 = (Spinner) findViewById(R.id.spinner6);
        Spinner spinner7 = (Spinner) findViewById(R.id.spinner7);
        TextView temp_coeff = (TextView) findViewById(R.id.temp_coeff);
        if (spinner5 != null && spinner6 != null && spinner7 != null && temp_coeff != null) {
            if (a == 3) {
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                temp_coeff.setVisibility(View.GONE);
            } else if (a == 4) {
                spinner5.setVisibility(View.VISIBLE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                temp_coeff.setVisibility(View.GONE);
            } else if (a == 5) {
                spinner5.setVisibility(View.VISIBLE);
                spinner6.setVisibility(View.VISIBLE);
                spinner7.setVisibility(View.GONE);
                temp_coeff.setVisibility(View.GONE);
            } else if (a == 6) {
                spinner5.setVisibility(View.VISIBLE);
                spinner6.setVisibility(View.VISIBLE);
                spinner7.setVisibility(View.VISIBLE);
                temp_coeff.setVisibility(View.VISIBLE);
            }
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
        int ringsNbr = Integer.valueOf(ringsNb[spinner_pos]);
        Resistance.setNbAnneaux(ringsNbr);
    }

    /**
     * evaluating value of a resistance with 3 rings
     */
    public double evaluationResVal3Rings() {
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal3());
        return computeValue(Resistance.getNbAnneaux(), R.getTabDouble());
    }

    /**
     * evaluating value of a resistance with 4 rings
     */
    public double evaluationResVal4Rings() {
        Resistance R = new Resistance(Resistance.getVal(), Resistance.getVal2(), Resistance.getVal3(), Resistance.getVal4());
        return computeValue2(Resistance.getNbAnneaux(), R.getTabDouble());
    }

    public double computeValue(int nbAnneaux, double[] tabDouble) {
        int soustractor = 2;
        if (nbAnneaux == 4) soustractor = 3;
        return (tabDouble[0] * Math.pow(10, (nbAnneaux - soustractor)) +
                tabDouble[1] * Math.pow(10, (nbAnneaux - (soustractor + 1)))) * Math.pow(10, tabDouble[2]);
    }

    public double computeValue2(int nbAnneaux, double[] tabDouble) {
        int soustractor = 3;
        if (nbAnneaux == 6) soustractor = 4;
        return (tabDouble[0] * Math.pow(10, (nbAnneaux - soustractor)) +
                tabDouble[1] * Math.pow(10, (nbAnneaux - (soustractor + 1))) +
                tabDouble[2] * Math.pow(10, (nbAnneaux - (soustractor + 2)))) * Math.pow(10, tabDouble[3]);
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal2(0.0);
            }
        });
    }

    public void takingSpinnerValueRes3Rings_2(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsMultiplierValues.ringsMultiplierColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal3(ColorsMultiplierValues.getMultiplierColorsValue().get(parent.getSelectedItem().toString()));
                double value = evaluationResVal3Rings();
                Resistance.setValResistance(value);
                TextView total = (TextView) findViewById(R.id.total);
                TextView tolerance = (TextView) findViewById(R.id.tolerance);
                if (total != null && tolerance != null) {
                    total.setText(String.valueOf(value));
                    tolerance.setText(getString(R.string.toleranceByDefault));
                }
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

    public void takingSpinnerValueRes4Rings_0(Spinner spinner) {
        CostomSpinnerAdapter adapter = new CostomSpinnerAdapter(this, ColorsToleranceValues.ringsToleranceColors());
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resistance.setVal4(ColorsToleranceValues.getToleranceColorsValue().get(parent.getSelectedItem().toString()));

                TextView tolerance = (TextView) findViewById(R.id.tolerance);
                if (tolerance != null) {
                    String tol = Resistance.getVal4() + getString(R.string.toleranceValue);
                    tolerance.setText(tol);
                }
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

                if (total != null) {
                    total.setText(String.valueOf(value));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal4(0.0);
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
                Resistance.setVal5(ColorsToleranceValues.getToleranceColorsValue().get(parent.getSelectedItem().toString()));

                TextView tolerance = (TextView) findViewById(R.id.tolerance);
                if (tolerance != null) {
                    String tol = Resistance.getVal5() + getString(R.string.toleranceValue);
                    tolerance.setText(tol);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal5(0.0);
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
                Resistance.setVal6(ColorsTemperatureCoefficientValues.getTemperatureCoefficientColorsValue().get(parent.getSelectedItem().toString()));

                TextView temp_coeff = (TextView) findViewById(R.id.temp_coeff);
                String temp_coefficient = "Temp. Coeff. : " + String.valueOf(Resistance.getVal6()) + " ppm";
                if (temp_coeff != null) {
                    temp_coeff.setText(temp_coefficient);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resistance.setVal6(0.0);
            }
        });
    }
}
