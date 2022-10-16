package com.company;

public class Palindrom {

    public boolean isPalindrom(String source) {
        if (source.length() < 2) {
            return true;
        }

        return source.charAt(0) == source.charAt(source.length() - 1) && isPalindrom(source.substring(1, source.length() - 1));
    }

}
