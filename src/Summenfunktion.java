public class Summenfunktion {
    public static void main(String[] args) {

    }
    int summeIterativ(int n){
        int ergebnis =0;
        for(int i=1;i<=n;i++){
            ergebnis+=i;
        }
        return ergebnis;
    }
    int summeRekursisv(int n){
        if(n==0){
            return 0;
        }
        return summeRekursisv(n-1)+n;
    }
    int potenzFunktion(int z1, int z2){
        //z1^z1
        return 0;
    }
}
