package com.example.roland.myapplication;

import android.graphics.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roland on 02/08/2016.
 */
public class ColorsValue {

    private Map<Integer, Double> colorsValues;

    public ColorsValue(){
        colorsValues = new HashMap<>();
        colorsValues.put(Color.BLACK, 0.0);
        //colorsValues.put(Color.BROWN, 1.0);
        colorsValues.put(Color.RED, 2.0);
        //colorsValues.put(Color.ORANGE, 3.0);
        colorsValues.put(Color.YELLOW, 4.0);
        colorsValues.put(Color.GREEN, 5.0);
        colorsValues.put(Color.BLUE, 6.0);
        //colorsValues.put(Color.VIOLET, 7.0);
        colorsValues.put(Color.GRAY, 8.0);
        colorsValues.put(Color.WHITE, 9.0);
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

    public Map<Integer, Double> getColorsValues() {
        return colorsValues;
    }

    public void setColorsValues(Map<Integer, Double> colorsValues) {
        this.colorsValues = colorsValues;
    }
}
