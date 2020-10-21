package org.academiadecodigo.gnunas;

public class Main {
    public static void main(String[] args) {
        Histogram histogram = new Histogram();

        histogram.add("Ola Ola Ola me lhamo Edu soy Edu adeus adeus");
        histogram.add("teste teste teste focus focus");

        for (String s : histogram) {
            System.out.println(s + " ---- " + histogram.get(s));
        }

        HistogramInheritance histogramInheritance = new HistogramInheritance();

        histogramInheritance.add("Ola Ola Ola me lhamo Edu soy Edu adeus adeus");
        histogramInheritance.add("teste teste teste focus focus");

        for (String s : histogramInheritance) {
            System.out.println(s + " ---- " + histogramInheritance.get(s));
        }
    }
}
