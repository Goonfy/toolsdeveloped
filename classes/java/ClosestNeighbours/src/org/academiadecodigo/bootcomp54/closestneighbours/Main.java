package org.academiadecodigo.bootcomp54.closestneighbours;

public class Main {
    public static void main(String[] args) {
        ClosestNeighbours closestNeighbours = new ClosestNeighbours();

        int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};
        int[] result = closestNeighbours.findClosest(myArray);

        // print the elements of the resulting array
        for (int res : result)
        {
            System.out.println(res);
        }
    }
}
