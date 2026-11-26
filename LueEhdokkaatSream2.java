import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class LueEhdokkaatSream2 {
    public static void main(String[] args) {
        
        // lista ehdokkaita varten
        ArrayList<Ehdokas> ehdokkaat = new ArrayList<>();

        try {
            Files.lines(Paths.get("ehdokkaat.txt"))
                .map(rivi -> rivi.split("\\s+"))
                .map(palaset -> new Ehdokas(palaset[0], palaset[1], palaset[2], Integer.parseInt(palaset[3])))
                .forEach(e -> ehdokkaat.add(e));

            // tähän streamien kokeilua

            System.out.println("EHDOKKAAT järjestyksessä -------------------------------------"); 

            // 1 Tulosta ehdokkaat äänimäärän mukaisessa järjestyksessä
            ehdokkaat.stream()
                .sorted((e1, e2) -> -e1.getAanimaara() + e2.getAanimaara())
                .forEach(e -> System.out.println(e));

            System.out.println("Yli 100 -------------------------------------");

            // 2 Tulosta ehdokkaat, joilla on yli 100 ääntä äänimäärän mukaisessa järjestyksessä
            ehdokkaat.stream()
                .filter(e -> e.getAanimaara() > 100)
                .sorted((e1, e2) -> -e1.getAanimaara() + e2.getAanimaara())
                .forEach(e -> System.out.println(e));

            System.out.println("Puolueiden nimet -------------------------------------");

            // 3 Tulosta kaikkien puolueiden lyhenteet kertaalleen aakkosjärjestyksessä
            ehdokkaat.stream()
                .map(e -> e.getPuolue())
                .distinct()
                .sorted()
                .forEach(puolue -> System.out.println(puolue));
            
            // 4 Tulosta kunkin puolueen eniten ääniä saaneen ehdokkaan sukunimi ja etunimi
            // en osaa

            // Kokeile muuttaa alussa oleva tiedoston lukeminen niin, että se tapahtuu streameilla

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
