
import java.util.*;

public class PlaceOfTheOlympiad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();
        long l = 0, r = m;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            long total = (m / (mid + 1) * mid + m % (mid + 1)) * n;
            if (total >= k) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.println(r);
    }
}
