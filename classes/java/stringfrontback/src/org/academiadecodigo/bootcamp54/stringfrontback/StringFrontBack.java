package org.academiadecodigo.bootcamp54.stringfrontback;

public class StringFrontBack {
    public void frontBack(String str) {
        // print result here
        System.out.println(str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0));
    }
}
