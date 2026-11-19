import java.util.*;
import java.nio.file.Paths;

// Tee ohjelma, joka lukee tiedoston kunnat.txt
// Ohjelma laskee kunkin maakunnan pinta-alan (summa maakunnan kuntien pinta-alasta)
// Ota pohjaksi HajautustauluLueKunnat.java
// HashMap<String, Double> maakuntienPA


public class HajautusPintaAla {
    public static void main(String[] args) {

        // Recordin määrittely
        record Municipality(String code, String name, String region,
            int population, double area) {};

        // hajautustaulu maakuntien pinta-alat
        HashMap<String, Double> citiesinRegions = new HashMap<>();

        try {
            Scanner file = new Scanner(Paths.get("kunnat.txt"));

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] pieces = line.split("\\s+");

                String code = pieces[0];
                String name = pieces[1];
                String region = pieces[2];
                int population = Integer.parseInt(pieces[3]);
                double area = Double.parseDouble(pieces[4]);

                Municipality m = new Municipality(code, name, region, population, area);

                if (!citiesinRegions.containsKey(region)) {
                    // maakuntaa ei ole vielä hajautustaulussa.
                    // Lisätään se ja laitetaan arvoksi ensimmäisen kunnan pinta-ala
                    citiesinRegions.put(region, area);
                }
                else {
                    // maakunta oli jo hajautustaulussa
                    double x = citiesinRegions.get(region);
                    citiesinRegions.put(region, x + area);
                }
            }

            // käydään läpi hajautustaulu
            for (HashMap.Entry<String, Double> pair : citiesinRegions.entrySet()) {
                String key = pair.getKey();
                double value = pair.getValue();
                System.out.println(key + " pinta-ala: " + value);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
