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
        colorsValues.put("#000000", 200.0);
        colorsValues.put("#582900", 100.0);
        colorsValues.put("#FF0000", 50.0);
        colorsValues.put("#ED7F10", 15.0);
        colorsValues.put("#FFFF00", 25.0);
        colorsValues.put("#0000FF", 10.0);
        colorsValues.put("#FFFFFF", 20.0);
        colorsValues.put("#660099", 5.0);
        colorsValues.put("#606060", 1.0);

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

    public static List<String> ringsTemperatureCoefficientColors(){
        //List<String> myColors = new ArrayList<>();
        Set myColors = getTemperatureCoefficientColorsValue().keySet(); //retourne la liste des clés du Map
        List listOfMyColors = new ArrayList( myColors ); //conversion du Set en List
        return listOfMyColors;
    }
}
