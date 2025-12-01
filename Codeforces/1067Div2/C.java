
import java.util.*;

public class C {

    public static long kadane(long[] nums) {
        long curr = nums[0];
        long best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            best = Math.max(best, curr);
        }
        return best;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }

            if (k == 0) {
                System.out.println(kadane(a));
            } else if (k % 2 == 0) {
                System.out.println(kadane(a));
            } else {

                long mxGlobal = kadane(a);
                long[] pre = new long[n];
                long[] post = new long[n];

                pre[0] = a[0];
                post[n - 1] = a[n - 1];

                for (int i = 1; i < n; i++) {
                    pre[i] = Math.max(a[i], pre[i - 1] + a[i]);
                }

                for (int i = n - 2; i >= 0; i--) {
                    post[i] = Math.max(a[i], post[i + 1] + a[i]);
                }

                long ans = mxGlobal;

                for (int i = 0; i < n; i++) {
                    long through = pre[i] + post[i] - a[i]; // we are finding sum with a[i] inclusion... but subtracting a[i] because it has been count twice in pre and post
                    ans = Math.max(ans, through + b[i]);
                }
                System.out.println(ans);
            }
        }
    }
}
