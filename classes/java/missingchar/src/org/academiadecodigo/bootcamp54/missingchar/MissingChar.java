package org.academiadecodigo.bootcamp54.missingchar;

public class MissingChar
{
    public void checkMissingChar(String str, int n) {
        // print result here
        System.out.println(str.substring(0, n) + str.substring(n + 1));
    }
}