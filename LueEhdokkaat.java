import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LueEhdokkaat {
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

            Collections.sort(ehdokkaat);

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
