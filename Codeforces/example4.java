import java.util.Scanner;

public class example4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] wealth = new long[n];
            long total = 0;
            long maxW = Long.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                wealth[j] = sc.nextLong();
                total += wealth[j];
                maxW = Math.max(maxW, wealth[j]);
            }

            double averageWealth = (double) total / n;
            double threshold = averageWealth / 2;
            int unhappyCount = 0;

            for (int j = 0; j < n; j++) {
                if (wealth[j] < threshold) {
                    unhappyCount++;
                }
            }

            if (unhappyCount > n / 2) {
                long requiredIncrease = (long) Math.ceil(threshold) - maxW;
                arr[i] = (requiredIncrease > 0) ? (int) requiredIncrease : 0;
            } else {
                arr[i] = -1;
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(arr[i]);
        }

        sc.close();
    }
}
