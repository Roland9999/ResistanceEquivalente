package com.example.roland.myapplication;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Roland on 02/08/2016.
 */
public class ColorsValue {


    public static Map<String, Integer> getColorsValue(){
        Map<String, Integer> colorsValues;
        colorsValues = new HashMap<>();
        colorsValues.put("#000000", 0);
        colorsValues.put("#582900", 1);
        colorsValues.put("#FF0000", 2);
        colorsValues.put("#ED7F10", 3);
        colorsValues.put("#FFFF00", 4);
        colorsValues.put("#096A09", 5);
        colorsValues.put("#0000FF", 6);
        colorsValues.put("#660099", 7);
        colorsValues.put("#606060", 8);
        colorsValues.put("#FFFFFF", 9);
        //colorsValues.put("#FFD700", 10);
        //colorsValues.put("#CECECE", 11);

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

    public static List<String> ringsColors(){
        //List<String> myColors = new ArrayList<>();
        Set myColors = getColorsValue().keySet(); //retourne la liste des clés du Map
        List listOfMyColors = new ArrayList( myColors ); //conversion du Set en List
        return listOfMyColors;
    }


}
