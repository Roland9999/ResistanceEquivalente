package com.example.roland.myapplication;


/**
 * Created by Roland on 02/08/2016.
 */
public class Resistance {

    private int nbAnneaux;
    private double[] tabDouble = {0.0,0.0,1.0,0.0,20.0,0.0};
    private double valResistance;

    public Resistance(double val, double val2, double val3){
        tabDouble[0] = val;
        tabDouble[1] = val2;
        tabDouble[2] = val3;

        valResistance = computeValue(nbAnneaux, tabDouble);
    }

    public Resistance(double val, double val2, double val3, double val4){
        tabDouble[0] = val;
        tabDouble[1] = val2;
        tabDouble[2] = val4;
        tabDouble[3] = val3;

        valResistance = computeValue(nbAnneaux, tabDouble);
    }

    public Resistance(double val, double val2, double val3, double val4, double val5){
        tabDouble[0] = val;
        tabDouble[1] = val2;
        tabDouble[2] = val4;
        tabDouble[3] = val3;
        tabDouble[4] = val5;

        valResistance = computeValue(nbAnneaux, tabDouble);
    }

    public Resistance(double val, double val2, double val3, double val4, double val5, double val6){
        tabDouble[0] = val;
        tabDouble[1] = val2;
        tabDouble[2] = val4;
        tabDouble[3] = val3;
        tabDouble[4] = val5;
        tabDouble[5] = val6;

        valResistance = computeValue(nbAnneaux, tabDouble);
    }

    public double computeValue(int nbAnneaux, double[] tabDouble){
        return  valResistance = ((tabDouble[0]*Math.pow(10.0,(nbAnneaux-1)))+
                (tabDouble[1]*Math.pow(10.0,(nbAnneaux-2)))+
                (tabDouble[3]*10*(nbAnneaux-3)))*Math.pow(10.0,tabDouble[2]);
    }

    public int getNbAnneaux() {
        return nbAnneaux;
    }

    public void setNbAnneaux(int nbAnneaux) {
        this.nbAnneaux = nbAnneaux;
    }

    public double[] getTabDouble() {
        return tabDouble;
    }

    public void setTabDouble(double[] tabDouble) {
        this.tabDouble = tabDouble;
    }

    public double getValResistance() {
        return valResistance;
    }

    public void setValResistance(double valResistance) {
        this.valResistance = valResistance;
    }
}
