import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the difference (d): ");
        int d = input.nextInt();
        System.out.print("Enter the start (n): ");
        double n = input.nextDouble();

        double result = calculateNestedSquareRoot(n, d);
        System.out.println("Result: " + result);
    }

    public static double calculateNestedSquareRoot(double n, int d) {
        if (n <= 0) {
            return 0; // Base case: return 0 for non-positive numbers
        }
        return Math.sqrt(n + calculateNestedSquareRoot(n - d, d));
    }
}
