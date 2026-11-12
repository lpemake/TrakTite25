import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class LueEhdokkaatSortLambda {
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

            // Collections.sort(ehdokkaat);
            // järjestä puolueittain sukunimen ja etunimen mukaan
            Comparator<Ehdokas> nimenMukaan = (e1, e2) -> {
                int result = e1.getPuolue().compareTo(e2.getPuolue());
                if (result == 0)
                    result = e1.getSukunimi().compareTo(e2.getSukunimi());
                if (result == 0)
                    result = e1.getEtunimi().compareTo(e2.getEtunimi());
                return result;
            };

            // järjestä äänimäärän mukaan
            Comparator<Ehdokas> aaniMaaranMukaan = (e1, e2) ->
                -e1.getAanimaara() + e2.getAanimaara();
            

            //Collections.sort(ehdokkaat, nimenMukaan);
            Collections.sort(ehdokkaat, aaniMaaranMukaan);

            for (Ehdokas ehdokas : ehdokkaat) {
                System.out.println(ehdokas.toString());
            }

            // laske äänien yhteismäärä
            double aanetYhteensa = 0;
            for (int i = 0; i < ehdokkaat.size(); i++) {
                aanetYhteensa += ehdokkaat.get(i).getAanimaara();
            }
            System.out.println("aanet yhteensä " + aanetYhteensa);

            // toisella tavalla
            aanetYhteensa = 0;
            for (Ehdokas ehdokas : ehdokkaat) {
                aanetYhteensa += ehdokas.getAanimaara();
            }
            System.out.println("aanet yhteensä " + aanetYhteensa);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
