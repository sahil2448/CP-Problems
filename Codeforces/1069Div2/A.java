
import java.util.*;

public class A {

    static final long TARGET = 1_000_000_000_000_000_000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(sc.nextInt());
            }

            long left = TARGET - n;
            int cLast = -1;

            while (left > 0) {
                int d = set.size();
                cLast = d;
                left--;

                if (set.contains(d)) {
                    break;
                } else {
                    set.add(d);
                }
            }

            System.out.println(cLast);
        }

    }
}
