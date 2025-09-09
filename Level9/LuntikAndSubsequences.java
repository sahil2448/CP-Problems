
import java.util.*;

public class LuntikAndSubsequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];

            long zeroCount = 0;
            long oneCount = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                if (arr[i] == 0) {
                    zeroCount++;
                } else if (arr[i] == 1) {
                    oneCount++;
                }
            }

            long result = (long) (oneCount * Math.pow(2, zeroCount)); // either i can select zero or ingore zero..(2^zerocount)
            System.out.println(result);
        }
    }
}
