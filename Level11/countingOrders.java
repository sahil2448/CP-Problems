
import java.util.*;

public class countingOrders {

    static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);

        long result = 1;
        for (int i = 0; i < n; i++) {
            int bi = b[n - 1 - i];
            int idx = upperBound(a, bi);
            long count = n - idx;
            long ways = Math.max(count - i, 0L);
            result = (result * ways) % MOD;
        }

        System.out.println(result);
    }

    /**
     * Returns the index of the first element in the sorted array that is
     * strictly greater than the given key. This is equivalent to finding the
     * upper bound of key in the array.
     *
     */
    private static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
