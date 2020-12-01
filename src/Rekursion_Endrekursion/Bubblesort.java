package Rekursion_Endrekursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bubblesort {
    public static void main(String[] args) {
        Random rnd = new Random();
        int spannweite = 10000;

        List<Integer> zahlen1 = new ArrayList<Integer>();
        for(int i = 0; i < spannweite; i++){
            zahlen1.add(rnd.nextInt(spannweite));
        }

        for(int i = 0; i<zahlen1.size();i++){
            System.out.println(zahlen1.get(i));

        }
        long startZeitSeq = System.nanoTime();
        for (int n=zahlen1.size(); n>1; --n){
            for (int i=0; i<n-1; ++i){
                if (zahlen1.get(i) > zahlen1.get(i+1)){
                    Collections.swap(zahlen1,i,i+1);
                }
            }
        }
        long endZeitSeq = System.nanoTime();
        long dauer = (endZeitSeq-startZeitSeq);
        System.out.println();
        for(int i = 0; i < zahlen1.size(); i++){
            System.out.println(zahlen1.get(i));
        }
        System.out.println("Benötigte Zeit: "+ dauer/1E9+" Sekunden");
    }

}
