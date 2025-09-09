
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long a[] = new long[(int) n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
            long ans = 0;
            for (long j = n - 1; j >= 0; j -= 2) {
                ans += a[(int) j];
            }
            System.out.println(ans);
        }
    }
}
