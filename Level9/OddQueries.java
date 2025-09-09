
import java.util.Scanner;

public class OddQueries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long q = sc.nextLong();

            long arr[] = new long[(int) n];

            long total = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                total += arr[i];
            }

            long prefixSum[] = new long[(int) n + 1];

            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
            }

            for (int i = 0; i < q; i++) {
                long l = sc.nextLong();
                long r = sc.nextLong();
                long k = sc.nextLong();

                long sum = prefixSum[(int) r] - prefixSum[(int) l - 1];

                long ans = total - sum + (r - l + 1) * k;

                if (ans % 2 == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }
    }
}
