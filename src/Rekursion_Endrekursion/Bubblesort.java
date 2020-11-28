package Rekursion_Endrekursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bubblesort {
    public static void main(String[] args) {
        Random rnd = new Random();

        List<Integer> zahlen1 = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++){
            zahlen1.add(rnd.nextInt(100));
        }
        for(int i = 0; i<zahlen1.size();i++){
            System.out.println(zahlen1.get(i));

        }
        for (int n=zahlen1.size(); n>1; --n){
            for (int i=0; i<n-1; ++i){
                if (zahlen1.get(i) > zahlen1.get(i+1)){
                    Collections.swap(zahlen1,i,i+1);
                }
            }
        }
        System.out.println();
        for(int i = 0; i < zahlen1.size(); i++){
            System.out.println(zahlen1.get(i));
        }
    }

}
