package com.company;

/**
 * Created by Leonardo on 23.11.2015.
 */
public class Sum {

    public static long accum(int... values) {
        long result = 0;
        for (int value: values) {
            result += value;
        }
        return result;
    }
}
