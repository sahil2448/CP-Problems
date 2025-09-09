
import java.util.*;

public class ValeriiAgainstEveryone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            Set<Long> set = new HashSet<>();

            for (long i = 0; i < n; i++) {
                set.add(sc.nextLong());
            }

            if (set.size() == n) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
