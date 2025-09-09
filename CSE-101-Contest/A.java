// NAME : SAHIL YUVRAJ KAMBLE
// ENROLLMENT NO. : 23112087

import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long[] a = new long[n];
            long total = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                total += a[i];
            }

            Arrays.sort(a);

            long L = total - y;
            long R = total - x;

            long countAtMostR = countPairs(a, R);
            long countBelowL = countPairs(a, L - 1);
            long result = countAtMostR - countBelowL;

            System.out.println(result);
        }
    }

    private static long countPairs(long[] a, long target) {
        int left = 0, right = a.length - 1;
        long count = 0;
        while (left < right) {
            if (a[left] + a[right] <= target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
