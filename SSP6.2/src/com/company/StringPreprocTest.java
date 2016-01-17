package com.company;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Leonardo on 23.11.2015.
 */
public class StringPreprocTest {

    @Test
    public void testSubstringBetweenNULL() throws Exception {
        assertNull("allert1", StringPreproc.substringBetween(null, "dsad", "asda"));
        assertNull("allert2", StringPreproc.substringBetween("dsad", null, "asda"));
        assertNull("allert3", StringPreproc.substringBetween("dsad", "asda", null));
    }

    @Test(expected = NullPointerException.class)
    public void testSubstringBetweenNPE() {
        StringPreproc.substringBetween(null, null, null);
    }

    @Test
    public void testSubstringBetweenEmptyStr() throws Exception {
        assertEquals("", StringPreproc.substringBetween("", "", ""));
    }

    @Test
    public void testSubstringBetweenOneRule() throws Exception {
        assertNull(StringPreproc.substringBetween("", "", "]"));
    }

    @Test
    public void testSubstringBetweenEmptyAndRule() throws Exception {
        assertNull(StringPreproc.substringBetween("", "[", "]"));
    }

    @Test
    public void testSubstringBetweenAtherVariant() throws Exception {
        assertEquals("", StringPreproc.substringBetween("yabcz","",""));
        assertEquals("abc", StringPreproc.substringBetween("yabcz","y","z"));
        assertEquals("abc", StringPreproc.substringBetween("yabczyabcz","y","z"));
        assertEquals("b", StringPreproc.substringBetween("wx[b]yz","[","]"));
    }

    @Test
    public void testOverlayNull() throws Exception {
        assertNull("null 1", StringPreproc.overlay(null, "a", 1, 2));
        assertNull("null 2", StringPreproc.overlay("a", null, 1, 2));
    }

    @Test
    public void testOverlayIncorectData() throws Exception {
        assertNull("Allert, 3 argument", StringPreproc.overlay("sa", "sad", -1, 2));
        assertNull("Allert, 4 argument", StringPreproc.overlay("sa", "sad", 1, -2));
    }

    @Test
    public void testOverlayIndexRule() throws Exception {
        assertNull(StringPreproc.overlay("sad", "dsa", 2, 1));
        assertNull(StringPreproc.overlay("sad", "dsa", 5, 9));
    }
}