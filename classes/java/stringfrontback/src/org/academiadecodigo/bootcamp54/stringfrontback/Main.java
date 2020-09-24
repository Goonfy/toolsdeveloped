package org.academiadecodigo.bootcamp54.stringfrontback;

public class Main {
    public static void main(String[] args) {
        StringFrontBack stringFrontBack = new StringFrontBack();

        stringFrontBack.frontBack("heisenberg");

        //receive command line argument if available
        if(args.length>0){
            stringFrontBack.frontBack(args[0]);
        }
    }
}
