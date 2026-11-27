import java.util.*;
import java.nio.file.*;

public class LueKunnatStream {
    public static void main(String[] args) {

        // Recordin määrittely
        record Municipality(String code, String name, String region,
            int population, double area) {};

        // tee ensin tiedoston lukeminen
        // Muuta siten, että käytetään streameja
        // Ota mallia ohjelmasta LueEhdokkaatSream.java
        ArrayList<Municipality> municipalities = new ArrayList<>();
        try {

            Files.lines(Paths.get("kunnat.txt"))
                .map(rivi -> rivi.split("\\s+"))
                .map(p -> new Municipality(p[0], p[1], p[2],
                    Integer.parseInt(p[3]), Double.parseDouble(p[4])))
                .forEach(m -> municipalities.add(m));
        
            // järjestäminen väkiluvun mukaan
            municipalities.stream()
                .sorted((k1, k2) -> k1.population() - k2.population())
                .forEach((k) -> System.out.println(k));

            // nimen mukaan
            municipalities.stream()
                .sorted((k1, k2) -> k1.name().compareTo(k2.name()))
                .forEach((k) -> System.out.println(k));  
                
            // laske kaikkien kuntien pinta-ala streamien avulla (mapToInt) (Voit harkita myös reducen käyttöä)
            double pintaAla = municipalities.stream()
                .mapToDouble(kunta -> kunta.area())
                .reduce(0, (edellinen, pa) -> edellinen + pa);
            System.out.println("Pinta-ala yhteensä: " + pintaAla);

            // tulosta maakuntien nimet aakkosjärjestyksessä
            municipalities.stream()
                .map(kunta -> kunta.region())
                .distinct()
                .sorted()
                .forEach(m -> System.out.println(m));


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
