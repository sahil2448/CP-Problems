import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int t = scanner.nextInt();

        // Array to store results
        int[] results = new int[t];

        // Process each test case
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            results[i] = n - 1; // Number of valid (a, b) pairs
        }

        // Print all results
        for (int res : results) {
            System.out.println(res);
        }

        scanner.close();
    }
}
