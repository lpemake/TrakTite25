import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LueNumerot {
    public static void main(String[] args) {
        
        ArrayList<Double> luvut = new ArrayList<>();

        try {
            Scanner file = new Scanner(Paths.get("numbers.txt"));

            while (file.hasNextLine()) {
                String row = file.nextLine();
                double number = Double.parseDouble(row);
                luvut.add(number);
            }

            Collections.sort(luvut);

            for (Double n : luvut) {
                System.out.print(n + " ");
            }

            // mediaani: keskimmäinen arvo järjestetystä aineistosta
            double median = luvut.get(luvut.size()/2);
            System.out.println("Mediaani: " + median);

            // suurin ja pienin luku
            double min = luvut.get(0);
            double max = luvut.get(luvut.size()-1);
            System.out.println("min ja max: " + min + " " + max);

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
