package Bubblesort;

import java.util.Random;

public class Bubblesort_Array {

    static int spannweite=100;
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
                }

            }
        }
    }

}
