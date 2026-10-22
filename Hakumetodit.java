import java.util.random.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hakumetodit {

    public static int linearSearch(int key, int[] data) {
        int place = -1;

        for (int i = 0; i < data.length; i++) {
            if (key == data[i]) {
                place = i;
                break;
            }
        }

        return place;
    }

    public static int binarySearch(int key, int[] data) {
        int low = 0;
        int high = data.length - 1;
   
        while(high >= low) {
            int middle = (low + high) / 2;
            if(data[middle] == key) {
                return middle;
            }
            if(data[middle] < key) {
                low = middle + 1;
            }
            if(data[middle] > key) {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int[] createAscendingData(int size) {
        int[] data = new int[size];
        
        // arvotaan numerot
        Random gen = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = gen.nextInt(size);
        }
        // järjestä
        Arrays.sort(data);
        return data;
    }

    public static void main(String[] args) {
        // kysy taulukon koko käyttäjältä
        // tee taulukko metodin createAscendingData avulla
        int size = 100000000;
        int[] data = createAscendingData(size);
        // kokeile hakuja ja mittaa suoritusajat
        long startTime = System.nanoTime();
        int place = linearSearch(size/2+1, data);
        long endTime = System.nanoTime();
        System.out.println("Linear search " + (endTime-startTime) + " ns");

        startTime = System.nanoTime();
        place = binarySearch(size/2+1, data);
        endTime = System.nanoTime();
        System.out.println("Binary search " + (endTime-startTime) + " ns");        
    }
}
