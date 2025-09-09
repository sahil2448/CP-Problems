
import java.util.*;

public class StableGroups {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();
        long x = sc.nextLong();

        long[] a = new long[(int) n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        Arrays.sort(a);

        ArrayList<Long> needed = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            long gap = a[i + 1] - a[i];
            if (gap > x) {
                long req = (gap - 1) / x;
                needed.add(req);
            }
        }

        Collections.sort(needed);

        long groups = 1 + needed.size();
        for (long req : needed) {
            if (k >= req) {
                k -= req;
                groups--;
            } else {
                break;
            }
        }

        System.out.println(groups);
    }
}
