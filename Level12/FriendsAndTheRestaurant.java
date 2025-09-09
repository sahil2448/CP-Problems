import java.util.*;

public class FriendsAndTheRestaurant {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            for (int i = 0; i < n; i++) b[i] = sc.nextLong();

            List<Long> d = new ArrayList<>();
            for (int i = 0; i < n; i++) d.add(b[i] - a[i]);
            Collections.sort(d);

            int l = 0, r = n - 1, ans = 0;
            while (l < r) {
                if (d.get(l) + d.get(r) >= 0) {
                    ans++;
                    l++;
                    r--;
                } else {
                    l++;
                }
            }
            System.out.println(ans);
        }
    }
}
