import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna taulukon koko");
        int koko = Integer.valueOf(lukija.nextLine());

        int[] luvut = new int[koko];

        System.out.println("Anna luvut");

        int i = 0;
        while (i < luvut.length) {
            luvut[i] = Integer.valueOf(lukija.nextLine());
            i++;
        }

        System.out.println("luvut");
        for (int j = 0; j < luvut.length; j++) {
            System.out.print(luvut[j]);
            System.out.print(", ");
        }
        System.out.println("järjestetty");
        Arrays.sort(luvut);

        // iteroiva for-lause (foreach)
        for (int luku : luvut) {
            System.out.print(luku + " ");
        } 
    }
}

