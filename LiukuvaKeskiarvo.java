import java.nio.*;
import java.nio.file.Paths;
import java.util.*;

public class LiukuvaKeskiarvo {
    public static void main(String[] args) {
        try {
            Queue<Double> que = new LinkedList<>();

            Scanner file = new Scanner(Paths.get("numbers.txt"));

            while (file.hasNextLine()) {
                String row = file.nextLine();
                double x = Double.parseDouble(row);

                que.add(x);
                if (que.size() > 10)
                    que.remove();

                double avg = 0;
                for (Double d : que) {
                    avg += d;
                }

                System.out.println(x + " " + avg);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("virhe");
        }
    }
}