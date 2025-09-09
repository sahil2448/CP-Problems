
import java.util.Scanner;

public class Bi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] a = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                total += a[i];
            }

            if (total < s) {
                System.out.println(-1);
                continue;
            }
            if (s == 0) {
                System.out.println(n);
                continue;
            }

            int maxLength = -1;
            int left = 0, sum = 0;
            for (int right = 0; right < n; right++) {
                sum += a[right];
                while (sum > s) {
                    sum -= a[left++];
                }
                if (sum == s) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }

            if (maxLength == -1) {
                System.out.println(-1);
            } else {
                System.out.println(n - maxLength);
            }
        }
    }
}
