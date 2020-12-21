package Insertionsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

//In diesem Programm wirdder Insertionsort Algorithmus verwendet
//Zu erst bei einer aufsteigenden Liste, dann bei einer absteigenden Liste
//Da die Absteigende Liste der ungünstigste Fall ist, brauch diese immer länger zum Sortieren

//Dann wird noch eine Liste wie bei Lotto befüllt (weil es sonst theoretisch unendlich lange doppelte Werte geben könnte)
//Lotto Methode:
//Eine Zahl wird gezogen, die gezogene wird mit der letzten Zahl im Array getauscht, dann wird der Algorithmus widerholt,
//jedoch mit -1 dass die zuvor gezogene nicht mehr gezogen werden kann.
//Sinn dahinter ist, dass es nicht unendlich oft fehlziehungen geben kann.
//Wie man am Ende bei der Ausgabe sieht, sobald man eine halbwegs hohe Zahl angibt, ist
//1. Bei aufsteigender Liste Insertionsort viel schneller, als Bubblesort ist
//2. Bei absteigender Liste Insertionsort ca. gleich schnell ist, als Bubblesort
//3. Bei einer random Liste Bubblesort sehr viel schneller ist, als Insertionsort
//Da die zufällige Liste am praxisnahesten ist merkt man, dass Bubblesort viel sinnvoller ist, als normaler Insertionsort

public class Lotto {
    static int spannweite;
    static int zaehler=0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Wie groß sollen die Arrays sein?");
        spannweite=reader.nextInt();

        int[] aufsteigendInsertion = new int[spannweite];
        int[] aufsteigendBubble = new int[spannweite];

        int[] absteigendInserion = new int[spannweite];
        int[] absteigendBubble = new int[spannweite];

        int[] randomInsertion = new int[spannweite];
        int[] randomBubble = new int[spannweite];


        //aufsteigend
        for(int i = 0; i<aufsteigendInsertion.length; i++){
            aufsteigendInsertion[i] = zaehler+1;
            aufsteigendBubble[i]=zaehler+1;
            zaehler++;
        }

        //Insertionsort
        long startZeit = System.nanoTime();
        aufsteigendInsertion=insertionSort(aufsteigendInsertion);
        long endZeit = System.nanoTime();
        long dauerAufsteigendInsertion = (endZeit-startZeit);

        zaehler=0;

        //Bubblesort
        startZeit = System.nanoTime();
        aufsteigendBubble=bubbleSort(aufsteigendBubble);
        endZeit = System.nanoTime();
        long dauerAufsteigendBubble = (endZeit-startZeit);

        zaehler=0;


        //absteigend:
        for(int i = 0; i<absteigendInserion.length; i++){
            int tmp = spannweite-zaehler;
            absteigendInserion[i]=tmp;
            absteigendBubble[i]=tmp;
            zaehler++;
        }

        //Insertionsort
        startZeit = System.nanoTime();
        absteigendInserion=insertionSort(absteigendInserion);
        endZeit=System.nanoTime();
        long dauerAbsteigendInsertion = (endZeit-startZeit);

        //Bubblesort
        startZeit = System.nanoTime();
        absteigendBubble=insertionSort(absteigendBubble);
        endZeit=System.nanoTime();
        long dauerAbsteigendBubble = (endZeit-startZeit);

        //Random
        randomInsertion=lotto(aufsteigendInsertion);
        randomBubble=lotto(aufsteigendBubble);

        //Insertion
        startZeit = System.nanoTime();
        randomInsertion=insertionSort(randomInsertion);
        endZeit = System.nanoTime();
        long dauerRandomInsertion = (endZeit-startZeit);

        //Bubble
        startZeit = System.nanoTime();
        randomInsertion=insertionSort(randomInsertion);
        endZeit = System.nanoTime();
        long dauerRandomBubble = (endZeit-startZeit);

        System.out.println();
        System.out.println("Dauer aufsteigend Insertion: " + dauerAufsteigendInsertion/1E3+ " Mikrosekunden");
        System.out.println("Dauer aufsteigend Bubble:    " + dauerAufsteigendBubble/1E3+ " Mikrosekunden");
        System.out.println();

        System.out.println("Dauer absteigend Insertion: " + dauerAbsteigendInsertion/1E3+ " Mikrosekunden");
        System.out.println("Dauer absteigend Bubble:    " + dauerAbsteigendBubble/1E3+ " Mikrosekunden");
        System.out.println();

        System.out.println("Dauer random Insertion: " + dauerRandomInsertion/1E3+ " Mikrosekunden");
        System.out.println("Dauer random Bubble:    " + dauerRandomBubble/1E3+ " Mikrosekunden");
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
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    zaehler++;
                }
            }
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
