
import java.util.*;

public class Scuza {

    private static int upperBound(long[] arr, long key) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            long[] a = new long[n];
            long[] b = new long[q];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int k = 0; k < q; k++) {
                b[k] = sc.nextLong();
            }

            long[] mxArr = new long[n];
            mxArr[0] = a[0];
            for (int i = 1; i < n; i++) {
                mxArr[i] = Math.max(a[i], mxArr[i - 1]);
            }

            long[] presumArr = new long[n];
            presumArr[0] = a[0];
            for (int i = 1; i < n; i++) {
                presumArr[i] = presumArr[i - 1] + a[i];
            }

            for (int i = 0; i < q; i++) {
                int idx = upperBound(mxArr, b[i]);
                if (idx == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print(presumArr[idx - 1] + " ");
                }
            }
            System.out.println();
        }
    }
}
