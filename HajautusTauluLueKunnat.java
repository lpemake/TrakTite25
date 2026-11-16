import java.util.*;
import java.nio.file.Paths;

public class HajautusTauluLueKunnat {
    public static void main(String[] args) {

        // Recordin määrittely
        record Municipality(String code, String name, String region,
            int population, double area) {};

        // hajautustaulu maakuntien kuntien lukumäärää varten
        HashMap<String, Integer> citiesinRegions = new HashMap<>();

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
                    // maakuntaa ei ole vielä hajautustaulussa. Lisätään
                    citiesinRegions.put(region, 1);
                }
                else {
                    // maakunta oli jo hajautustaulussa
                    int lkm = citiesinRegions.get(region);
                    citiesinRegions.put(region, ++lkm);
                }
            }

            // käydään läpi hajautustaulu
            for (HashMap.Entry<String, Integer> pair : citiesinRegions.entrySet()) {
                String key = pair.getKey();
                int value = pair.getValue();
                System.out.println(key + ": " + value);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
