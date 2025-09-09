
import java.util.*;

public class MakeEqualAgain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if (n == 1) {
                System.out.println(0);
                continue;
            }

            Set<Integer> vals = new HashSet<>();
            for (int v : a) {
                vals.add(v);
            }

            int answer = n;
            for (int val : vals) {
                int left = 0;
                while (left < n && a[left] == val) {
                    left++;
                }
                int right = n - 1;
                while (right >= 0 && a[right] == val) {
                    right--;
                }
                answer = Math.min(answer, right - left + 1);
            }
            if (answer < 0) {
                answer = 0;
            }
            System.out.println(answer);
        }
    }
}
