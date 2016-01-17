package com.company;

/**
 * Created by Leonardo on 23.11.2015.
 */
public class StringPreproc {

    public static String substringBetween(String str, String open, String close) {

        if (str == null || open == null || close == null) {

            if (str == null && open == null && close == null)
                throw new NullPointerException();
            return null;
        }

        if (str.length() == 0) {
            if (open.length() == 0 && close.length() == 0)
                return "";
            return null;
        }

        if (str.indexOf(open) > str.indexOf(close))
            return null;

        String result = "";
        for (int i = str.indexOf(open) + 1; i < str.indexOf(close); ++i)
            result += str.charAt(i);

        return result;
    }

    public static String overlay(String str, String overlay, int start, int end) {

        if (overlay != null)
            if (str != null) {
                if (start >= 0 && end >= 0) {
                    if (start < end && str.length() > start) {
                        //work zone
                        StringBuilder _str = new StringBuilder(str);

                        for (int i = start; i < end; i++) {
                            _str.setCharAt(i, overlay.charAt(i));
                        }
                        return _str.toString();

                        //end work zone
                    }
                }
            }

        return null;
    }

}
