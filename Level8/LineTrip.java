package LevelEightK;

import java.util.Scanner;

public class LineTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t--;
            int l = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n + 1];
            a[0] = 0;

            // Input the array a[] and calculate the maximum distance
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                l = Math.max(l, a[i] - a[i - 1]);
            }

            // Update l with the max value between 2*m - 2*a[n] and the calculated maximum distance
            l = Math.max(2 * m - 2 * a[n], l);

            // Output the result
            System.out.println(l);
        }

        sc.close();
    }
}
