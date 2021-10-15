package map;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        int[] a1 = {1, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] b1 = {8, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] s = add(a1,b1);
        System.out.println("Addition: ");
        for(int i=0; i<s.length; i++){
            System.out.print(s[i]);
        }
        System.out.println();
        System.out.println("Subtraktion: ");
        int[] a2 = {8, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] b2 = {5, 4, 0, 0, 0, 0, 0, 0, 0};
        int[] d = differenz(a2,b2);
        for(int i=0; i<d.length; i++){
            System.out.print(d[i]);
        }
        System.out.println();
        System.out.println("Produkt: ");
        int[] a3 = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        int b3 = 2;
        int[] p = produkt(a3,b3);
        for(int i=0; i<p.length; i++) {
            System.out.print(p[i]);
        }
        System.out.println();
        System.out.println("Divison: ");
        int[] a4 = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        int b4 = 2;
        int[] di = division(a4,b4);
        for(int i=0; i<di.length; i++) {
            System.out.print(di[i]);
        }
    }

    /**
     * Macht die Summe zweier Zahlen die auf je ein Array dargestellt sind
     * @param a ist ein Array auf den ein Zahl dargestellt ist
     * @param b ist ein Array auf den ein Zahl dargestellt ist
     * @return die Summe der Zwei Zahlen die auf a und b dargestellt sind, die selbst auf ein anderes Array
     * dargestellt ist
     */
    public static int[] add(int[] a, int[] b){
        int[] s = new int[a.length];
        for(int i=0; i<a.length; i++){
            s[i] = a[i] + b[i];
        }
        return(carry_add(s));
    }

    public static int[] differenz(int[] a, int[] b){
        int[] d = new int[a.length];
        for(int i=0; i < a.length; i++){
            d[i] = a[i] - b[i];
        }
        return carry_diff(d);
    }

    public static int[] produkt(int[] a, int b){
        int[] p = new int[a.length];
        for(int i=0; i < a.length; i++){
            p[i] = a[i] * b;
        }
        return carry_add(p);
    }

    public static int[] division(int[] a, int b){
        int[] d = new int[a.length];
        for(int i=0; i < a.length; i++){
            if(a[i] % b != 0) {
                if(i < a.length-1) {
                    a[i+1] = a[i+1] + a[i] % 2 * 10;
                    a[i] = a[i] - a[i] % 2;
                }
            }
            d[i] = a[i] / b;
        }
        while(d[0] == 0){
            int[] d_aux = new int[d.length-1];
            for(int j=1; j<d.length; j++) d_aux[j-1] = d[j];
            d = d_aux;
        }
        return d;
    }

    /**
     * bekommet ein Array als parameter und restrukturiert es so dass jedes Element ein Ziffer des Zahls ist
     * @param a ist ein Array auf den ein Zahl dargestellt ist
     * @return das Array nach ich es restrukturiert habe so dass es nur Ziffer sind
     */
    public static int[] carry_add(int[] a){
        int change = 0;
        for(int i=0; i < a.length; i++){
            if (a[i] >= 10) {
                change = 1;
                if (i == 0) {
                    int[] a_aux = new int[a.length + 1];
                    a_aux[0] += 1;
                    a_aux[1] = a[0] % 10;
                    for (int j = 1; j < a.length; j++){
                        a_aux[j+1] = a[j];
                    }
                    a = a_aux;
                } else {
                    a[i-1] += 1;
                    a[i] = a[i] % 10;
                }
            }
        }
        if(change == 1) a = carry_add(a);
        return(a);
    }

    public static int[] carry_diff(int[] a){
        int change = 0;
        for(int i=0; i < a.length; i++){
            if (a[i] < 0) {
                if (i != 0) {
                    change = 1;
                    a[0] -= 1;
                    a[1] = 10 + a[1] ;
                    if (a[0] == 0) {
                        int[] a_aux = new int[a.length - 1];
                        for (int j = 1; j < a.length; j++){
                            a_aux[j-1] = a[j];
                        }
                        a = a_aux;
                    }
                }
            }
        }
        if(change == 1) a = carry_diff(a);
        return(a);
    }

}
