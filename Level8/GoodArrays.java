
import java.util.*;

public class GoodArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            int n = sc.nextInt();
            long ans = 0;
            long arr[] = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();

            }
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] % 2 == arr[i + 1] % 2) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
