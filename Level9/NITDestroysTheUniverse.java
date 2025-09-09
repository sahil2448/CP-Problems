
import java.util.*;

public class NITDestroysTheUniverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextInt();
            long arr[] = new long[(int) n];

            long zeroCount = 0;
            for (long i = 0; i < n; i++) {
                arr[(int) i] = sc.nextLong();
                if (arr[(int) i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == n) {
                System.out.println(0);
                continue;
            }

            long left = 0;
            long right = n - 1;

            while (arr[(int) left] == 0) {
                left++;
            }
            while (arr[(int) right] == 0) {
                right--;
            }

            boolean foundZero = false;
            for (long i = left; i <= right; i++) {
                if (arr[(int) i] == 0) {
                    foundZero = true;
                }
            }

            if (foundZero) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }

        }
    }
}
