
import java.util.*;

public class RomanticGlasses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Set<Long> seen = new HashSet<>();
            seen.add(0L); 

            long sumOdd = 0;  
            long sumEven = 0; 

            boolean ok = false;
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    sumOdd += a[i];
                } else {
                    sumEven += a[i];
                }
                long diff = sumOdd - sumEven;
                if (seen.contains(diff)) {
                    ok = true;
                    break;
                }
                seen.add(diff);
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }
}
