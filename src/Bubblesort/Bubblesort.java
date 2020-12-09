package Bubblesort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
