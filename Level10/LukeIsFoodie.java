
import java.util.*;

public class LukeIsFoodie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();

            ArrayList<Long> arr[] = new ArrayList[(int) n];
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                arr[i] = new ArrayList<>();
                arr[i].add(a - x);
                arr[i].add(a + x);
            }

            long l = arr[0].get(0);
            long r = arr[0].get(1);

            long ans = 0;
            for (int i = 1; i < n; i++) {
                l = Math.max(l, arr[i].get(0));
                r = Math.min(r, arr[i].get(1));
                if (l > r) {
                    ans++;
                    l = arr[i].get(0);
                    r = arr[i].get(1);
                }
            }

            System.out.println(ans);
        }
    }

}
