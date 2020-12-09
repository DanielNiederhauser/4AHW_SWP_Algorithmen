package Rekursion_Endrekursion;

public class Potenzfunktion {
    //Rekursion Beispiel mit der Potenzfunktion, z1^z2
    public static void main(String[] args) {
        System.out.println(potenzFunktion(2,32));
    }
    static long potenzFunktion(int z1, int z2){
        if(z2==1){
            return z1;
        }
        else {
            return z1*potenzFunktion(z1,z2-1);
        }

    }
}
