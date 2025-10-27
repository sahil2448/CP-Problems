
import java.util.*;

public class IncrementalPath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }

    static void solve(Scanner sc) {
        long n = sc.nextLong();
        long m = sc.nextLong();
        String s = sc.next();

        TreeSet<Long> white = new TreeSet<>();
        for (long i = 1; i <= 2 * (n + m); i++) {
            white.add(i);
        }

        TreeSet<Long> ans = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            long t = sc.nextLong();
            white.remove(t);
            ans.add(t);
        }

        long cur = 1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                cur++;
                if (white.contains(cur)) {
                    white.remove(cur);
                    ans.add(cur);
                }
            } else {
                Long temp = white.higher(cur); // higher means --> upper bound 
                if (temp == null) {
                    continue;
                }
                cur = temp;
                Long next = white.higher(cur);
                if (next == null) {
                    continue;
                }
                cur = next;
                white.remove(temp);
                ans.add(temp);
            }
        }

        System.out.println(ans.size());
        for (long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
