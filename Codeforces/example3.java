import java.util.Scanner;

public class example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] ans = new String[t];

        for (int m = 0; m < t; m++) { // Start from 0 to t-1
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            long totalLeaves = 0;

            totalLeaves += n * n;

            long startYear = Math.max(1, n - k + 1);
            long endYear = n - 1;

            if (endYear >= startYear) {
                long sumOfSquaresEnd = sumOfSquares(endYear);
                long sumOfSquaresStartMinusOne = sumOfSquares(startYear - 1);
                totalLeaves += sumOfSquaresEnd - sumOfSquaresStartMinusOne;
            }

            if (totalLeaves % 2 == 0) {
                ans[m] = "YES";
            } else {
                ans[m] = "NO";
            }
        }

        for (String result : ans) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static long sumOfSquares(long m) {
        return m * (m + 1) * (2 * m + 1) / 6;
    }
}
