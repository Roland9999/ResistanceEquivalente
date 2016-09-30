package com.example.roland.myapplication;

import android.graphics.Color;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Benalouane_R on 09/09/2016.
 */
public class AddAResistanceUnitaireTest {

   private AddAResistance addAResistance = new AddAResistance();


    @Test
    public void testOfComputeValueMethode() throws Exception{
        double[] tabDouble = {0.0,0.0,0.0,0.0,20.0,0.0};
        assertEquals(0, addAResistance.computeValue(3, tabDouble), 0);
    }

    @Test
    public void testOfComputeValueMethode2() throws Exception{
        double[] tabDouble = {9.0,5.0,0.0,2.0,20.0,0.0};
        assertEquals(9500.0, addAResistance.computeValue(3, tabDouble), 0);
    }

    @Test
    public void testOfComputeValueMethode3() throws Exception{
        double[] tabDouble = {7.0,3.0,1.0,1.0,10.0,0.0};
        assertEquals(7310.0, addAResistance.computeValue(5, tabDouble), 0);
    }

    @Test
    public void testOfComputeValueMethode4() throws Exception {
        double[] tabDouble = {7.0,3.0,5.0,-2.0,10.0,5.0};
        assertNotEquals(7.310, addAResistance.computeValue(6, tabDouble), 0);
    }

    @Test
    public void testOfComputeValueMethode5() throws Exception {
        double[] tabDouble = {7.0,3.0,5.0,-2.0,10.0,5.0};
        assertEquals(7.35, addAResistance.computeValue(6, tabDouble), 0.00005);
    }
}
