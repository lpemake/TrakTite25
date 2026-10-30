import java.util.Arrays;
import java.util.Random;

public class SelectionSortTest {

    public static int[] createRandomData(int size) {
        int[] data = new int[size];
        
        // arvotaan numerot
        Random gen = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = gen.nextInt(size);
        }
        return data;
    }
    
    // lisää selection sort
    // https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/ 
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;           
        }
    }

    public static void printData(int[] data) {
        for (int item : data) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 1000000;
        int[] data = createRandomData(size);

        // ota aika
        // kutsu metodia
        long startTime = System.nanoTime();
        selectionSort(data);
        long endTime = System.nanoTime();
        System.out.println("kesto " + (endTime-startTime)/1.0e9 + " s");

        //printData(data);

    }
}