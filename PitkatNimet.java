import java.util.*;
import java.nio.file.Paths;


public class PitkatNimet {
    public void main(String[] args) {

        try {
            Scanner lukija = new Scanner(Paths.get("names.txt"));
            List<String> syotteet = new ArrayList<>();

            // luetaan syotteet
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                if (rivi.equals("loppu")) {
                    break;
                }

                syotteet.add(rivi);
            }

            syotteet.stream()
                .filter(s -> s.length() > 10)
                .distinct()
                .sorted()
                .forEach(s -> System.out.println(s));
        }
        catch (Exception e) {
            System.out.println("virhe");
        }
    }
}