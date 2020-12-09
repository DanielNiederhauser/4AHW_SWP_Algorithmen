package Bubblesort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//In diesem Programm wird der Bubblesort-Algorithmus mit einer Liste angewendet
//Außerdem wird die Dauer der Sortierung berechnet
//Die zu sortierende Liste ist zufällig befüllt
//Kurz Prinzip: eine for-Schleife die solange abläuft, wie die Liste Inhalte besitzt
//Wenn das nächste Element kleiner als das zuvor ist, wird es getauscht. (Da es mit einer Liste geschieht, kann man Collections)

public class Bubblesort {
    public static void main(String[] args) {
        Random rnd = new Random();
        int spannweite = 10;

        List<Integer> zahlen1 = new ArrayList<Integer>();
        for(int i = 0; i < spannweite; i++){
            zahlen1.add(rnd.nextInt(spannweite));
        }
        System.out.println("Liste vor Sortieren");
        for(int i=0; i < zahlen1.size(); i++){
            System.out.print(zahlen1.get(i) + " ");
        }
        long startZeit = System.nanoTime();
        bubbleSort(zahlen1);
        long endZeit = System.nanoTime();

        long dauer = (endZeit-startZeit);
        System.out.println();
        System.out.println("Liste nach Sortieren");
        for(int i=0; i < zahlen1.size(); i++){
            System.out.print(zahlen1.get(i) + " ");
        }
        System.out.println();
        System.out.println("Benötigte Zeit: "+ dauer/1000+" Millisekunden");
    }

    public static void bubbleSort(List<Integer> tempList){
        for (int n=tempList.size(); n>1; --n){
            for (int i=0; i<n-1; ++i){
                if (tempList.get(i) > tempList.get(i+1)){
                    Collections.swap(tempList,i,i+1);
                }
            }
        }
    }
}
