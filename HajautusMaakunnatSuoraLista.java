import java.util.*;
import java.nio.file.Paths;

// tee ohjelma ilman Region-luokkaa
// hajautustaulun tyyppi on nyt
// HashMap<String, ArrayList<Municipality> citiesinRegions = new HashMap<>();

public class HajautusMaakunnatSuoraLista {
    public static void main(String[] args) {


        // hajautustaulu maakuntien kunnista
        HashMap<String, ArrayList<Municipality>> citiesinRegions = new HashMap<>();

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
                    citiesinRegions.put(region, new ArrayList<>());
                }
                ArrayList<Municipality> municipalities = citiesinRegions.get(region);
                municipalities.add(m);
            }

            // käydään läpi hajautustaulu
            for (HashMap.Entry<String, ArrayList<Municipality>> pair : citiesinRegions.entrySet()) {
                String key = pair.getKey();
                ArrayList<Municipality> municipalities = pair.getValue();
                System.out.println("Maakunta: " + key);

                // käydään läpi maakuntien kunnat
                System.out.println("Kunnat:");
                
                for (Municipality m : municipalities) {
                    System.out.println(m.toString());
                }

                System.out.println();

            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("virhe");
        }
    }
}
