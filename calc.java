public class calc {
    public static void main(String[] args) {
        double desiredResult = 8.570005694486145; // Example: desired result
        int n = findN(desiredResult);
        System.out.println("Value of n: " + n);
    }

    public static int findN(double desiredResult) {
        int n = 1;
        double result = calculateNestedSqrt(n);
        while (result < desiredResult) {
            n += 2; // Decrementing by 2 as per the nested square root expression
            result = calculateNestedSqrt(n);
        }
        return n;
    }

    public static double calculateNestedSqrt(int n) {
        if (n == 1) {
            return Math.sqrt(1);
        } else {
            return Math.sqrt(n + calculateNestedSqrt(n - 2));
        }
    }
}
