package com.nhnacdemy.kihunjung.tdd;

public class StringUtils {
    public static boolean isPalindrome(String candidate) {
        StringBuilder sb = new StringBuilder(candidate);
        String reversedStr = sb.reverse().toString();


        if(candidate.equals(reversedStr)){
            return true;
        }
        return false;
    }
}
