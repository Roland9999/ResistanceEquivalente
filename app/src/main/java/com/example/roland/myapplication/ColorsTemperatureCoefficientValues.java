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

    public static Map<String, Double> getTemperatureCoefficientColorsValue() {
        Map<String, Double> colorsValues;
        colorsValues = new HashMap<>();
        colorsValues.put("#582900", 100.0); //brown
        colorsValues.put("#FF0000", 50.0); //red
        colorsValues.put("#FFFF00", 25.0); //yellow
        colorsValues.put("#ED7F10", 15.0); //orange
        colorsValues.put("#0000FF", 10.0); //blue
        colorsValues.put("#660099", 5.0); // violet
        colorsValues.put("#606060", 1.0); // gray

        return colorsValues;
    }

    public static List<String> ringsTemperatureCoefficientColors() {
        Set myColors = getTemperatureCoefficientColorsValue().keySet(); //retourne la liste des clés du Map
        List<String> listOfMyColors = new ArrayList(myColors); //conversion du Set en List
        AlgorithmToSort.sortListColorsRing6(listOfMyColors); //utilisation de l'algorithme de trie
        return listOfMyColors;
    }
}
