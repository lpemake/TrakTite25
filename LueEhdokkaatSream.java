import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LueEhdokkaatSream {
    public static void main(String[] args) {
        
        // lista ehdokkaita varten
        ArrayList<Ehdokas> ehdokkaat = new ArrayList<>();

        try {
            Scanner file = new Scanner(Paths.get("ehdokkaat.txt"));

            while (file.hasNextLine()) {
                String row = file.nextLine();
                // palastellaan
                String[] pieces = row.split("\\s+");
                if (pieces.length != 4)
                    continue;
                String etunimi = pieces[0];
                String sukunimi = pieces[1];
                String puolue = pieces[2];
                int aanimaara = Integer.parseInt(pieces[3]);
                // tehdään olio
                Ehdokas e = new Ehdokas(etunimi, sukunimi, puolue, aanimaara);
                // lisätään olio listaan
                ehdokkaat.add(e);
            }

            // tähän streamien kokeilua
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
