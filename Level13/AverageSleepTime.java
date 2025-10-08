
import java.util.*;

public class AverageSleepTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long prefixSum[] = new long[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }

        long totalSumOfWindows = 0;
        for (int i = 0; i <= n - k; i++) {
            long windowSum = prefixSum[i + k] - prefixSum[i];
            totalSumOfWindows += windowSum;
        }

        int numberOfWindows = n - k + 1;

        double average = (double) totalSumOfWindows / numberOfWindows;

        System.out.printf("%.8f\n", average);

    }
}
