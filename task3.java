import java.util.Arrays;
import java.util.Scanner;

public class task3 {

    // Variables to store the best division
    static int minDifference = Integer.MAX_VALUE;
    static int[] bestSet1;
    static int[] bestSet2;

    // Function to solve the container division problem
    public static void divideContainers(int[] containers) {
        int n = containers.length;

        int[] set1 = new int[n / 2];
        int[] set2 = new int[n / 2];

        // Recursively try all possible combinations of containers
        divideUtil(containers, set1, set2, 0, 0, 0);

        // Print the results of the best division
        System.out.println("Первое множество:");
        System.out.print("Контейнеры: ");
        for (int i = 0; i < bestSet1.length; i++) {
            int index = indexOf(containers, bestSet1[i]) + 1; // Adjust index to start from 1
            System.out.print(index + " ");
        }
        System.out.println("\nМасса первого множества: " + Arrays.stream(bestSet1).sum() + " т");

        System.out.println("\nВторое множество:");
        System.out.print("Контейнеры: ");
        for (int i = 0; i < bestSet2.length; i++) {
            int index = indexOf(containers, bestSet2[i]) + 1; // Adjust index to start from 1
            System.out.print(index + " ");
        }
        System.out.println("\nМасса второго множества: " + Arrays.stream(bestSet2).sum() + " т");
    }

    // Helper recursive function to try all possible divisions
    public static void divideUtil(int[] containers, int[] set1, int[] set2, int i, int j, int diff) {
        int n = containers.length;

        // If we have processed all containers
        if (i == n) {
            // Check if the current division is better than the best one found so far
            if (Math.abs(diff) < minDifference) {
                minDifference = Math.abs(diff);
                bestSet1 = Arrays.copyOf(set1, set1.length);
                bestSet2 = Arrays.copyOf(set2, set2.length);
            }
            return;
        }

        // Add the current container to the first set
        if (j < n / 2) {
            set1[j] = containers[i];
            divideUtil(containers, set1, set2, i + 1, j + 1, diff + containers[i]);
        }

        // Add the current container to the second set
        if (i - j < n / 2) {
            set2[i - j] = containers[i];
            divideUtil(containers, set1, set2, i + 1, j, diff - containers[i]);
        }
    }

    // Method to find the index of an element in an array
    public static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // If the element is not found
    }

    public static void main(String[] args) {
        int[] containers = {10, 15, 18, 20, 16, 14};
        System.out.println();
        divideContainers(containers);
    }
}
