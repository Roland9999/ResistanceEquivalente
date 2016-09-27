package com.example.roland.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Roland on 03/08/2016.
 */
public class ColorsMultiplierValues {

    public static Map<String, Double> getMultiplierColorsValue() {
        Map<String, Double> colorsValues;
        colorsValues = new HashMap<>();
        colorsValues.put("#000000", 0.0);
        colorsValues.put("#582900", 1.0);
        colorsValues.put("#FF0000", 2.0);
        colorsValues.put("#ED7F10", 3.0);
        colorsValues.put("#FFFF00", 4.0);
        colorsValues.put("#096A09", 5.0);
        colorsValues.put("#0000FF", 6.0);
        colorsValues.put("#660099", 7.0);
        //colorsValues.put("#606060", 8.0);
        colorsValues.put("#FFD700", -1.0);
        colorsValues.put("#CECECE", -2.0);

        return colorsValues;
    }
/*
    <item name="Black">#000000</item>
    <item name="Brown">#582900</item>
    <item name="Red">#FF0000</item>
    <item name="Orange">#ED7F10</item>
    <item name="Yellow">#FFFF00</item>
    <item name="Green">#096A09</item>
    <item name="Blue">#0000FF</item>
    <item name="Violet">#660099</item>
    <item name="Gray">#606060</item>
    <item name="White">#FFFFFF</item>
    <item name="Gold">#FFD700</item>
    <item name="Silver">#CECECE</item>
*/

    public static List<String> ringsMultiplierColors() {
        //List<String> myColors = new ArrayList<>();
        Set myColors = getMultiplierColorsValue().keySet(); //retourne la liste des clés du Map
        List listOfMyColors = new ArrayList( myColors ); //conversion du Set en List
        AlgorithmToSort.sortListColorsRing4(listOfMyColors); // utilisation de l'algorithme de trie
        return listOfMyColors;
    }

}
