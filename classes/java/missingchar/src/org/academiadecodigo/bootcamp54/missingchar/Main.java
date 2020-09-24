package org.academiadecodigo.bootcamp54.missingchar;

public class Main {
    public static void main(String[] args) {
        MissingChar missingChar = new MissingChar();

        missingChar.checkMissingChar("Robocop", 3);

        //receive command line argument if available
        if(args.length>=2){
            missingChar.checkMissingChar(args[0], Integer.parseInt(args[1]));
        }
    }
}
