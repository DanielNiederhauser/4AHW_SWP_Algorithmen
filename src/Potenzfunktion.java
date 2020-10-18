public class Potenzfunktion {
    public static void main(String[] args) {
        System.out.println(potenzFunktion(4,10));
    }
    static int potenzFunktion(int z1, int z2){
        if(z2==1){
            return z1;
        }
        else {
            return z1*potenzFunktion(z1,z2-1);
        }

    }
}
