import java.util.*;

public class Circuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n * 2];

            int cnt0 = 0;
            for (int i = 0; i < n * 2; i++) {
                a[i] = sc.nextInt();
                cnt0 += a[i];
            }

            int first = cnt0 & 1;
            int second = Math.min(cnt0, n * 2 - cnt0);

            System.out.println(first + " " + second);
        }
    }
}
