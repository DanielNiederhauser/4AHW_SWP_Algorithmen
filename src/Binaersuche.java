import java.util.Arrays;
import java.util.*;
import java.util.Random;

public class Binaersuche {
    public static void main(String[] args) {

        //Deklarationen
        int zaehler=1;
        int spannweite = 100;
        int [] zahlen = new int[spannweite];
        int suchZahl;
        Random rnd = new Random();
        Scanner reader = new Scanner(System.in);
        //Benutzereingabe
        System.out.println("[R]andom zahlen oder [N]ormal");
        switch (reader.nextLine().toLowerCase().charAt(0)){
            case 'n':
                //Array normal befüllen
                for(int i = 0; i < zahlen.length; i++){
                    zahlen[i] = zaehler;
                    zaehler++;
                }
                break;
            case'r':
                //Array random befüllen
                for(int i = 0; i < zahlen.length; i++){
                    zahlen[i] = rnd.nextInt(spannweite+1);
                    zaehler++;
                }

                Arrays.sort(zahlen);
                break;
            default:
                System.out.println("Falsche Eingabe!");
                break;
        }
        System.out.println("Zu suchende Zahl: ");
        suchZahl=reader.nextInt();


        boolean ergebnisSequentiell;
        long startZeitSeq = System.nanoTime();
        ergebnisSequentiell = sequentielleSuche(zahlen, suchZahl);
        long endZeitSeq = System.nanoTime();

        if(ergebnisSequentiell==true){

            System.out.println("Zahl " + suchZahl + " in " + (endZeitSeq-startZeitSeq) + " Nanosekunden mithilfe Sequentieller Suche in dem Array gefunden!");
        }

        else {
            System.out.println("Zahl nicht gefunden!");
        }

        System.out.println("Kontrollieren? [j,n]");
        if(reader.next().toLowerCase().charAt(0)=='j') {
            //Array ausgeben
            for (int i = 0; i < zahlen.length; i++) {
                System.out.println(zahlen[i]);
            }
        }
        System.out.println("Binär: ");
        if(binaereSuche(zahlen, spannweite,suchZahl)==true){
            System.out.println("Zahl gefunden");
        }else {
            System.out.println("Zahl nicht gefunden");
        }



    }
    public static boolean sequentielleSuche(int[] zahlen, int suchZahl){
        for(int i=0; i < zahlen.length; i++){
            if(zahlen[i]==suchZahl){
                return true;
            }
        }
        return false;
    }
    public static boolean binaereSuche(int[] zahlen,int rechts, int suchZahl) {
        int links=0;
        rechts = zahlen.length;

        int mitte;
        do{
            mitte=zahlen.length/2;
            if(zahlen[mitte]==suchZahl){
                return true;
            }
            else if(suchZahl > zahlen[mitte]){
                mitte=links;
            }
            else if(suchZahl < zahlen[mitte] ){
                mitte=rechts;
            }
        }while(zahlen[mitte] != suchZahl && links <= rechts);
        return false;

    }
}
