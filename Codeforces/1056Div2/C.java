
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int mod = 676767677;
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if (n == 1) {
                int count = 0;
                for (int candidate = 0; candidate <= 1; candidate++) {
                    if (candidate == candidate + n - a[0]) {
                        count++;
                    }
                }
                System.out.println(count);
            } else {
                int[] d = new int[n - 1];
                for (int i = 0; i < n - 1; i++) {
                    d[i] = a[i + 1] - a[i] + 1;
                }
                int count = 0;
                for (int candidate = 0; candidate <= 1; candidate++) {
                    int current = candidate;
                    int total_x = candidate;
                    boolean valid = true;
                    for (int i = 0; i < n - 1; i++) {
                        int next = d[i] - current;
                        if (next < 0 || next > 1) {
                            valid = false;
                            break;
                        }
                        total_x += next;
                        current = next;
                    }
                    if (valid && total_x == candidate + n - a[0]) {
                        count++;
                    }
                }
                System.out.println(count % mod);
            }
        }
    }
}
