
import java.util.Scanner;

public class MainakArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            long max = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();

            }

            if (n == 1) {
                System.out.println(0);
                continue;
            } else {

                for (int i = 1; i < n; i++) {
                    max = Math.max(arr[i] - arr[0], max);
                }
                for (int i = 0; i < n - 1; i++) {
                    max = Math.max(arr[(int) n - 1] - arr[i], max);
                }

                for (int i = 0; i < n - 1; i++) {
                    max = Math.max(arr[i] - arr[i + 1], max);
                }

                System.out.println(max);

            }
        }
    }

}
