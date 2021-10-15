package map;

import static java.lang.Math.abs;

public class Main {

    //concatenez fiecare el din arr intr-un numar
    public static int arr_to_int(int[] arr){
        int rez = 0;
        for (int i = 0; i < arr.length; i++) {
            rez = rez * 10 + arr[i];
        }
        return rez;
    }

    //pun fiecare cifra dintr-un numar intr-un array
    public static int[] int_to_arr(int nr, int n){
        int[] rez = new int[n];
        for(int i = 0; i < n; i++){
            rez[n-1-i] = nr % 10;
            nr = nr / 10;
        }
        return rez;
    }

    public static int nr_cifre(int x){
        int n = 0;
        while(x != 0){
            n++;
            x = x / 10;
        }
        return n;
    }

    public static void main(String[] args) {
        //Summe
        System.out.println("Summe");
        int[] a = {1, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] b = {8, 7, 0, 0, 0, 0, 0, 0, 0};
        int nr1=0;
        int nr2=0;
        int s=0;

        nr1 = arr_to_int(a);
        nr2 = arr_to_int(b);

        s = nr1 + nr2;

        int n= nr_cifre(s);

        int[] sum = int_to_arr(s, n);

        for (int j = 0; j < n; j++) {
            System.out.print(sum[j]+" ");
        }
        //diff
        System.out.println();
        System.out.println("Differenz");
        int[] a2 = {8, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] b2 = {5, 4, 0, 0, 0, 0, 0, 0, 0};
        nr1=0; nr2=0;

        nr1 = arr_to_int(a2);
        nr2 = arr_to_int(b2);

        int d = abs(nr1-nr2);

        n=nr_cifre(d);

        int[] diff = int_to_arr(d, n);

        for (int j = 0; j < n; j++) {
            System.out.print(diff[j]+" ");
        }

        //multiplikation
        System.out.println();
        System.out.println("Multiplikation");
        int[] a3 = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        int b3 = 2;
        nr1=0;

        nr1 = arr_to_int(a3);

        int p = nr1 * b3;

        n=nr_cifre(p);

        int[] prod = int_to_arr(p, n);

        for (int j = 0; j < n; j++) {
            System.out.print(prod[j]+" ");
        }

        //division
        System.out.println();
        System.out.println("Division");
        int[] a4 = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        int b4 = 2;
        nr1=0;

        nr1 = arr_to_int(a4);
        int div = nr1 / b3;

        n=nr_cifre(div);

        int[] diviz = int_to_arr(div, n);

        for (int j = 0; j < n; j++) {
            System.out.print(diviz[j]+" ");
        }
    }

}
