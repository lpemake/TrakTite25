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
            Collections.sort(municipalities, (k1, k2) -> k1.population() - k2.population());

            for (Municipality municipality : municipalities) {
                System.out.println(municipality);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
