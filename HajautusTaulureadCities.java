import java.util.*;
import java.nio.file.Paths;

public class HajautusTaulureadCities {
    public static void main(String[] args) {
        
        try {
            Scanner file = new Scanner(Paths.get("cities.txt"));

            HashMap<String, ArrayList<String>> states = new HashMap<>();

            while (file.hasNextLine()) {
                String row = file.nextLine();
                String[] pieces = row.split(";");

                String city = pieces[0];
                String state = pieces[1];

                if (!states.containsKey(state)) {
                    // ei löytynyt. lisätään hajautustauluun uusi osavaltio
                    states.put(state, new ArrayList<>());
                }
                // lisätään uusi kaupunki listaan oikean osavaltion kohdalle
                states.get(state).add(city);
            }

            // käydään hajautustaulu läpi
            for (HashMap.Entry<String, ArrayList<String>> pair : states.entrySet()) {
                String state = pair.getKey();
                System.out.println(state);
                System.out.println("--");
                ArrayList<String> listOfCities = pair.getValue();
                // käydään läpi kaupungit
                for (String city : listOfCities) {
                    System.out.println(city);
                }
                System.out.println();
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error");
        }
    }
}
