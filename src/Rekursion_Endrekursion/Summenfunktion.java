package Rekursion_Endrekursion;

public class Summenfunktion {
    public static void main(String[] args) {
        System.out.println(summeRekursisv(9));
        System.out.println(summeIterativ(9));
    }
    static int summeIterativ(int n){
        int ergebnis =0;
        for(int i=1;i<=n;i++){
            ergebnis+=i;
        }
        return ergebnis;
    }
        static int summeRekursisv(int n){
        if(n==0){
            return 0;
        }
        return summeRekursisv(n-1)+n;
    }
}
