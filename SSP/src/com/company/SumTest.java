package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Leonardo on 23.11.2015.
 */
public class SumTest {

    @Test
    public void testAccumInt() throws Exception {
        assertEquals(15, Sum.accum(1, 2, 3, 4, 5));
    }

    @Test
    public void testAccumLong() throws Exception {
        long expected = 900000000L * 6;
        assertEquals(expected, Sum.accum(900000000, 900000000, 900000000, 900000000, 900000000, 900000000));
    }

}