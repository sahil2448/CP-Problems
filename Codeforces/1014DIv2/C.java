
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            long arr[] = new long[(int) n];
            long max = Long.MIN_VALUE;
            long evens = 0;
            long odds = 0;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                Long x = sc.nextLong();
                arr[i] = x;
                if (x % 2 != 0) {
                    odds++;
                } else {
                    evens++;
                }
                sum += x;
                max = Math.max(x, max);
            }
            if (odds == 0 || evens == 0) {
                System.out.println(max);
            } else {
                System.out.println(sum - odds + 1);
            }

        }
    }
}
