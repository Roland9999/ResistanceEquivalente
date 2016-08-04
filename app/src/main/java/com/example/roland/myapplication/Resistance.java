package com.example.roland.myapplication;


/**
 * Created by Roland on 02/08/2016.
 */
public class Resistance {

    private static int nbAnneaux;
    private double[] tabDouble = {0.0,0.0,1.0,0.0,20.0,0.0};
    private double valResistance;
    private static double val, val2, val3, val4, val5;

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
        int soustracteur = 2;
        if (nbAnneaux == 5) soustracteur = 3;
        if (nbAnneaux == 6) soustracteur = 4;
        return  valResistance = ((tabDouble[0]*Math.pow(10.0,(nbAnneaux-soustracteur)))+
                (tabDouble[1]*Math.pow(10.0,(nbAnneaux-(soustracteur + 1))))+
                (tabDouble[3]*10*(nbAnneaux-(soustracteur + 2))))*Math.pow(10.0,tabDouble[2]);
    }

    public static int getNbAnneaux() {
        return nbAnneaux;
    }

    public static void setNbAnneaux(int nbAnneaux) {
        Resistance.nbAnneaux = nbAnneaux;
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

    public static double getVal() {
        return val;
    }

    public static void setVal(double val) {
        Resistance.val = val;
    }

    public static double getVal2() {
        return val2;
    }

    public static void setVal2(double val2) {
        Resistance.val2 = val2;
    }

    public static double getVal3() {
        return val3;
    }

    public static void setVal3(double val3) {
        Resistance.val3 = val3;
    }

    public static double getVal4() {
        return val4;
    }

    public static void setVal4(double val4) {
        Resistance.val4 = val4;
    }

    public static double getVal5() {
        return val5;
    }

    public static void setVal5(double val5) {
        Resistance.val5 = val5;
    }
}
