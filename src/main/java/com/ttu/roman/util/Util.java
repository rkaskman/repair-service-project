package com.ttu.roman.util;


public class Util {
    public static boolean isEmptyOrOnlyWhiteSpaces(String s) {
       return s == null || "".equals(s.trim());
    }
}
