
import java.util.*;

public class SumOfMedians {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            long arr[] = new long[(int) (n * k)];
            for (int i = 0; i < n * k; i++) {
                arr[i] = sc.nextLong();
            }

            long step = n / 2;
            long medianSum = 0;

            long i = n * k - 1 - step;
            while (k > 0) {
                medianSum += arr[(int) i];
                i = i - step -1;
                k--;
            }
            System.out.println(medianSum);
        }
    }
}
