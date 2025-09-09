
import java.util.*;

public class StrongVertices {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long a[] = new long[(int) n];
            long b[] = new long[(int) n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }

            long c[] = new long[(int) n];
            ArrayList<Long> ans = new ArrayList<>();
            long mx = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                c[i] = a[i] - b[i];
                mx = Math.max(mx, c[i]);
            }

            for (int i = 0; i < n; i++) {
                if (c[i] == mx) {
                    ans.add((long) i + 1);
                }
            }

            System.out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }

            System.out.println();

        }
    }

}
