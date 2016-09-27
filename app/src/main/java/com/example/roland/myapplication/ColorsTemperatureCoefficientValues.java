package com.example.roland.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Roland on 04/08/2016.
 */
public class ColorsTemperatureCoefficientValues {

    public static Map<String, Double> getTemperatureCoefficientColorsValue(){
        Map<String, Double> colorsValues;
        colorsValues = new HashMap<>();
        colorsValues.put("#000000", 200.0); //"Black"
        colorsValues.put("#582900", 100.0); //"Brown"
        colorsValues.put("#FF0000", 50.0); //"Red"
        colorsValues.put("#ED7F10", 15.0); //"Orange"
        colorsValues.put("#FFFF00", 25.0); //"Yellow"
        colorsValues.put("#0000FF", 10.0); //"Blue"
        colorsValues.put("#FFFFFF", 20.0); //"White"
        colorsValues.put("#660099", 5.0); //"Violet"
        colorsValues.put("#606060", 1.0); //"Gray"

        return colorsValues;
    }

    public static List<String> ringsTemperatureCoefficientColors(){
        Set myColors = getTemperatureCoefficientColorsValue().keySet(); //retourne la liste des clés du Map
        //List listOfMyColors = new ArrayList( myColors ); //conversion du Set en List
        return new ArrayList( myColors );
    }
}
