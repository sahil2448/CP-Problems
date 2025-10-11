import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            Map<Integer, Integer> cnt = new TreeMap<>();
            for (int x : a) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

            long base = 0;
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();

            for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
                int x = e.getKey();
                int c = e.getValue();
                base += (long) x * (c / 2);
                if (c % 2 == 1) odd.add(x);
                else if (c >= 2) even.add(x);
            }

            if (base == 0) {
                System.out.println(0);
                continue;
            }

            long ans = 0;
            for (int x : odd) {
                if (2 * base > x) ans = Math.max(ans, 2 * base + x);
            }

            for (int i = 1; i < odd.size(); i++) {
                int prev = odd.get(i - 1);
                int cur = odd.get(i);
                if ((long) prev + 2 * base > cur) {
                    ans = Math.max(ans, (long) prev + 2 * base + cur);
                }
            }

            for (int x : even) {
                if (base - x > 0) ans = Math.max(ans, 2 * base);
            }

            System.out.println(ans);
        }
    }
}
