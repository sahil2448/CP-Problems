
import java.util.*;

public class MaximumSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            long totalSum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                totalSum += arr[i];
            }
            Arrays.sort(arr);

            long[] preSum = new long[n];
            preSum[0] = arr[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + arr[i];
            }

            int K = k;
            long minRemoved = preSum[2 * K - 1];
            long sumLargestRemoved = 0;
            int j = n - 1;

            for (int x = 1; x <= K; x++) {
                sumLargestRemoved += arr[j--];
                int remainingPairs = K - x;
                long removedSmall = remainingPairs > 0
                        ? preSum[2 * remainingPairs - 1]
                        : 0;
                minRemoved = Math.min(minRemoved, sumLargestRemoved + removedSmall);
            }

            System.out.println(totalSum - minRemoved);
        }
    }
}
