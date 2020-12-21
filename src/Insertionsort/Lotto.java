package Insertionsort;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    static int spannweite;
    static int zaehler=0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Wie groß sollen die Arrays sein?");
        spannweite=reader.nextInt();

        int[] aufsteigend = new int[spannweite];
        int[] absteigend = new int[spannweite];
        int[] random = new int[spannweite];

        //aufsteigend
        for(int i = 0; i<aufsteigend.length; i++){
            aufsteigend[i] = zaehler+1;
            zaehler++;
        }

        long startZeit = System.nanoTime();
        aufsteigend=insertionSort(aufsteigend);
        long endZeit = System.nanoTime();
        long dauerAufsteigend = (endZeit-startZeit);

        zaehler=0;

        //absteigend:
        for(int i = 0; i<absteigend.length; i++){
            int tmp = spannweite-zaehler;
            absteigend[i]=tmp;
            zaehler++;
        }
        System.out.println();

        startZeit = System.nanoTime();
        absteigend=insertionSort(absteigend);
        endZeit=System.nanoTime();
        long dauerAbsteigend = (endZeit-startZeit);

        startZeit = System.nanoTime();
        random=lotto(aufsteigend);
        endZeit = System.nanoTime();
        long dauerRandom = (endZeit-startZeit);

        System.out.println("Random");
        for (int i = 0; i < random.length; i++) {
            System.out.print(random[i] + ", ");
        }

        System.out.println();
        System.out.println("Dauer aufsteigend: " + dauerAufsteigend/1E3+ " Mikrosekunden");
        System.out.println("Dauer absteigend: " + dauerAbsteigend/1E3+ " Mikrosekunden");
        System.out.println("Dauer random: " + dauerRandom/1E3+ " Mikrosekunden");

    }
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int tmp;
            tmp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
    public static int[] lotto(int[] aufsteigendesArr) {
        Random rnd = new Random();
        int[] fertig = new int[spannweite];

        int index;
        int tmp;
        for (int i = 0; i < fertig.length; ++i) {
            index= rnd.nextInt(aufsteigendesArr.length-i);
            fertig[i]=aufsteigendesArr[index];
            tmp=aufsteigendesArr[aufsteigendesArr.length-i-1];
            aufsteigendesArr[aufsteigendesArr.length-i-1]=aufsteigendesArr[index];
            aufsteigendesArr[index] = tmp;
        }
        return fertig;
    }

}
