import java.util.*;
import java.nio.file.Paths;

public class HajautusMaakunnat {
    public static void main(String[] args) {


        // hajautustaulu maakuntien kunnista
        HashMap<String, Region> citiesinRegions = new HashMap<>();

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
                    // tehdään maakuntaolio
                    citiesinRegions.put(region, new Region(region));
                }
                Region r = citiesinRegions.get(region);
                r.addMunicipality(m);
            }

            // käydään läpi hajautustaulu
            for (HashMap.Entry<String, Region> pair : citiesinRegions.entrySet()) {
                String key = pair.getKey();
                Region r = pair.getValue();
                System.out.println("Maakunta: " + key);

                // käydään läpi maakuntien kunnat
                System.out.println("Kunnat:");
                System.out.println(r.toString());
                System.out.println();

            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("virhe");
        }
    }
}
