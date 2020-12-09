package Bubblesort;

import java.util.Random;

public class Bubblesort_Array {


    //In diesem Programm wird der Bubblesort-Algorithmus mit einem Array angewendet
    //Außerdem wird die Dauer der Sortierung berechnet
    //Das zu sortierende Array ist zufällig befüllt
    //Kurz Prinzip: eine for-Schleife die solange abläuft, wie das Array lang ist
    //Wenn das nächste Element kleiner als das zuvor ist, wird es getauscht.

    static int spannweite=1000;
    static int zaehler=0;

    public static void main(String[] args) {
        Random rnd = new Random();
        int [] zahlen1 = new int[spannweite];
        for(int i = 0; i < spannweite; i++){
            zahlen1[i]=(rnd.nextInt(spannweite));
        }


        System.out.println("Array vor sortieren");
        for(int i=0; i < zahlen1.length; i++){
            System.out.print(zahlen1[i] + " ");
        }
        System.out.println();
        long startZeit = System.nanoTime();
        bubbleSort(zahlen1);
        long endZeit = System.nanoTime();
        long dauer = (endZeit-startZeit);

        System.out.println("Array nach sortieren");
        for(int i=0; i < zahlen1.length; i++){
            System.out.print(zahlen1[i] + " ");
        }
        System.out.println();
        System.out.println("Benötigte Zeit: "+ dauer/1000+" Millekunden");
        System.out.println("Schritte: " + zaehler);


    }
    static void bubbleSort(int[] zahlen) {
        int n = zahlen.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (zahlen[j - 1] > zahlen[j]) {
                    temp = zahlen[j - 1];
                    zahlen[j - 1] = zahlen[j];
                    zahlen[j] = temp;
                    zaehler++;
                }

            }
        }
    }

}
