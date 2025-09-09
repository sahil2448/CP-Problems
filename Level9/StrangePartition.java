
import java.util.*;

public class StrangePartition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long arr[] = new long[(int) n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            long min = 0;
            for (int i = 0; i < n; i++) {
                min += arr[i];
            }

            min = Math.ceilDiv(min, x);
            long max = 0;
            for (int i = 0; i < n; i++) {
                max += Math.ceilDiv(arr[i], x);
            }

            System.out.println(min + " " + max);
        }
    }
}
