
import java.util.*;

public class KevinAndArithmetic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] odds = new int[n];
            int[] evens = new int[n];
            int oddCnt = 0, evenCnt = 0;
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();
                if (v % 2 == 0) {
                    evens[evenCnt++] = v;
                } else {
                    odds[oddCnt++] = v;
                }
            }
            int[] arrange = new int[n];
            int idx = 0;
            for (int i = 0; i < evenCnt; i++) {
                arrange[idx++] = evens[i];
            }
            for (int i = 0; i < oddCnt; i++) {
                arrange[idx++] = odds[i];
            }

            long s = 0;
            int pts = 0;
            for (int i = 0; i < n; i++) {
                s += arrange[i];
                if (s % 2 == 0) {
                    pts++;
                    while (s % 2 == 0) {
                        s /= 2;
                    }
                }
            }
            System.out.println(pts);
        }
    }
}
