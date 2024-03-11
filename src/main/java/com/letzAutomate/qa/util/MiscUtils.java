package com.letzAutomate.qa.util;

public class MiscUtils {
	// Method to check if a string can be parsed as an integer
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
