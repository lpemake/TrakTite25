import java.util.*;
import java.nio.file.Paths;

public class LueKunnat {
    public static void main(String[] args) {

        // Recordin määrittely
        record Municipality(String code, String name, String region,
            int population, double area) {};

        // tee ensin tiedoston lukeminen
        ArrayList<Municipality> municipalities = new ArrayList<>();
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
                municipalities.add(m);
                //System.out.println(m.toString());
            }
            // järjestäminen väkiluvun mukaan
            Collections.sort(municipalities, (k1, k2) -> k1.population() - k2.population());

            // nimen mukaan
            Collections.sort(municipalities, (k1, k2) -> k1.name().compareTo(k2.name()));

            // maakunnan ja nimen mukaan
            Comparator<Municipality> byRegionAndName = (k1, k2) -> {
                int result = k1.region().compareTo(k2.region());
                if (result == 0)
                    result = k1.name().compareTo(k2.name());
                return result;
            };
            Collections.sort(municipalities, byRegionAndName);

            // pinta-alan mukaan (huom double-tyyppi)
            Collections.sort(municipalities, (k1, k2) -> {
                double delta = k1.area() - k2.area();
                if (delta > 1.0e-12) return 1;
                if (delta < -1.0e-12) return -1;
                else return 0;
            });

            Collections.sort(municipalities, (k1, k2) -> Double.compare(k1.area(), k2.area()));

            for (Municipality municipality : municipalities) {
                System.out.println(municipality);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
