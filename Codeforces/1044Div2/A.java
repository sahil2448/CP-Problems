
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            HashSet<Integer> seen = new HashSet<>();
            boolean ok = false;
            for (int x : a) {
                if (seen.contains(x)) {
                    ok = true;
                    break;
                }
                seen.add(x);
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }
}
