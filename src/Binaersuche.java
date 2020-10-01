import java.awt.*;
import java.util.Arrays;
import java.util.*;
import java.util.Random;

public class Binaersuche {
    public static void main(String[] args) {

        //Deklarationen
        int zaehler=1;
        int spannweite = 10000000;
        int [] zahlen = new int[spannweite];
        int suchZahl = 0;
        boolean sequentiellGefunden;
        boolean binaerGefunden;
        Random rnd = new Random();
        Scanner reader = new Scanner(System.in);
        //Benutzereingabe
        System.out.println("[R]andom zahlen oder [N]ormal");
        switch (reader.nextLine().toUpperCase().charAt(0)){
            case 'N':
                //Array normal befüllen
                for(int i = 0; i < zahlen.length; i++){
                    zahlen[i] = zaehler;
                    zaehler++;
                }
                break;
            case'R':
                //Array random befüllen
                for(int i = 0; i < zahlen.length; i++){
                    zahlen[i] = rnd.nextInt(spannweite+1);
                    zaehler++;
                }

                Arrays.sort(zahlen);
                break;
            default:
                System.out.println("Falsche Eingabe!");
                System.exit(0);
                break;
        }
        System.out.println("[R]andom Zahl oder [S]elber aussuchen?");
        switch (reader.nextLine().toUpperCase().charAt(0)){
            case'R':
                suchZahl= rnd.nextInt(spannweite+1);
                break;
            case 'S':
                System.out.println("Ihre Zahl: ");
                suchZahl = reader.nextInt();
                break;
                default:
                    System.out.println("Falsche Eingabe");
                    System.exit(0);
        }




        long startZeitSeq = System.nanoTime();
        sequentiellGefunden = sequentielleSuche(zahlen, suchZahl);
        long endZeitSeq = System.nanoTime();
        long seqDauer = (endZeitSeq-startZeitSeq);
        if(sequentiellGefunden==true){

            System.out.println("Zahl " + suchZahl + " in " + seqDauer + " Nanosekunden mithilfe Sequentieller Suche in dem Array gefunden!");
        }

        else {
            System.out.println("Zahl nicht gefunden!");
            for (int i = 0; i < zahlen.length; i++) {
                System.out.println(zahlen[i]);
            }
            System.exit(0);
        }

        System.out.println("Kontrollieren? [j,n]");

        if(reader.next().toLowerCase().charAt(0)=='j') {
            //Array ausgeben
            for (int i = 0; i < zahlen.length; i++) {
                System.out.println(zahlen[i]);
            }
        }

        long startZeitBinaer = System.nanoTime();
        binaerGefunden = binaereSuche(zahlen, suchZahl);
        long endZeitBinaer = System.nanoTime();
        long binDauer= (endZeitBinaer-startZeitBinaer);
        if(binaerGefunden){
            System.out.println("Zahl " + suchZahl + " in " + binDauer + " Nanosekunden mithilfe Binärer Suche in dem Array gefunden!");
        }
        else{
            System.out.println("nicht gefunden");
        }
        //Float zu Double, da Berechnung nicht funkt
        double binDauerDouble = binDauer;
        double seqDauerDouble = seqDauer;
        double prozent = Math.round(spannweite*(binDauerDouble/seqDauerDouble));
        System.out.println();
        System.out.println("Vergleich: ");
        System.out.print("Sequentielles Verfahren Dauer: " + seqDauer + " Nanosekunden  ,  ");
        System.out.println("Binäres Verfahren Dauer: " + binDauer + " Nanosekunden");
        System.out.println("Daraus folgt, dass das Binaere Verfahren um " + (seqDauer-binDauer) +
                " Nanosekunden --> " + (prozent) + " Prozent schneller ist!");




    }
    public static boolean sequentielleSuche(int[] zahlen, int suchZahl){
        for(int i=0; i < zahlen.length; i++){
            if(zahlen[i]==suchZahl){
                return true;
            }
        }
        return false;
    }
    public static boolean binaereSuche(int[] zahlen, int suchZahl) {
        int links=0;
        int rechts = zahlen.length;

        int mitte=(links+rechts)/2;
        while(zahlen[mitte] != suchZahl && links <= rechts ){
            mitte=(links+rechts)/2;

            if(suchZahl > zahlen[mitte]){
                links=mitte+1;
            }
            if(suchZahl < zahlen[mitte] ){
                rechts=mitte-1;
            }
        }
        if(zahlen[mitte]==suchZahl){
            return true;
        }
        else{
            return  false;
        }

    }
}