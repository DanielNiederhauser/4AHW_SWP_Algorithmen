package Rekursion_Endrekursion;

class Fibonacci {
    //Fibonacci als Beispiel für ENDREKURSION
    static int fibRekursiv(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibRekursiv(n - 1) + fibRekursiv(n - 2);
        }
    }

    static int hilfsmethode(int n, int a, int b) {
        if (n <= 1) {
            return a + b;
        } else {
            return hilfsmethode(n - 1, (a + b), a);
        }
    }

    static int fibEndrekursiv(int n) {
        return hilfsmethode(n - 1, 1, 0);
    }


    public static void main(String args[]) {
        int n = 9;
        System.out.println("Rekursiv: " + fibRekursiv(n));
        System.out.println("Endrekursiv: " + fibEndrekursiv(9));
    }
} 