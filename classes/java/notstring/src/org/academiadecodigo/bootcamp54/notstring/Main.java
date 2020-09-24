package org.academiadecodigo.bootcamp54.notstring;

public class Main {
    public static void main(String[] args) {
        NotString notString = new NotString();

        notString.removeString("semicolon");
        notString.removeString("not semicolon");

        //receive command line argument if available
        if(args.length>0){
            notString.removeString(args[0]);
        }
    }
}
