package com.example.roland.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Roland on 04/08/2016.
 */
public class ColorsToleranceValues {

    public static Map<String, Double> getToleranceColorsValue() {
        Map<String, Double> colorsValues;
        colorsValues = new HashMap<>();
        colorsValues.put("#FFFFFF", 20.0); //white
        colorsValues.put("#CECECE", 10.0); //silver
        colorsValues.put("#FFD700", 5.0); //gold
        colorsValues.put("#FF0000", 2.0); //red
        colorsValues.put("#582900", 1.0); //brown
        colorsValues.put("#096A09", 0.5); //green
        colorsValues.put("#0000FF", 0.25); //blue
        colorsValues.put("#660099", 0.1); //violet
        colorsValues.put("#606060", 0.05); //gray

        return colorsValues;
    }

    public static List<String> ringsToleranceColors() {
        Set myColors = getToleranceColorsValue().keySet(); //retourne la liste des clés du Map
        List<String> listOfMyColors = new ArrayList(myColors); //conversion du Set en List
        AlgorithmToSort.sortListColorsRing5(listOfMyColors); //utilisation de l'algorithme de trie
        return listOfMyColors;
    }
}
