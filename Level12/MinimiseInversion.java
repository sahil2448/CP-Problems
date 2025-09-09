
import java.util.*;

public class MinimiseInversion {

    static class Pair {

        int first, second;

        Pair(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Pair[] ab = new Pair[n];
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                ab[i] = new Pair(a[i], b[i]);
            }

            Arrays.sort(ab, Comparator.comparingInt(p -> p.first));

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    out.append(' ');
                }
                out.append(ab[i].first);
            }
            out.append('\n');

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    out.append(' ');
                }
                out.append(ab[i].second);
            }
            out.append('\n');
        }
        System.out.print(out.toString());
    }
}
