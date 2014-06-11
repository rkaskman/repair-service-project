package com.ttu.roman.util;


public class Util {
    public static boolean isEmptyOrOnlyWhiteSpaces(String s) {
       return s == null || "".equals(s.trim());
    }

    public static  boolean isPositiveInteger(String val) {
        return val != null && val.matches("[1-9][0-9]*");
    }
}
