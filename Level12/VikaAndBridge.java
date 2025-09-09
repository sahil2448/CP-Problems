
import java.util.*;

public class VikaAndBridge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = sc.nextInt();
            }

            int[] last = new int[k];
            Arrays.fill(last, -1);
            int[] max_step = new int[k];
            int[] max2_step = new int[k];

            for (int i = 0; i < n; i++) {
                int idx = c[i] - 1;
                int step = i - last[idx];
                if (step > max_step[idx]) {
                    max2_step[idx] = max_step[idx];
                    max_step[idx] = step;
                } else if (step > max2_step[idx]) {
                    max2_step[idx] = step;
                }
                last[idx] = i;
            }

            for (int i = 0; i < k; i++) {
                int step = n - last[i];
                if (step > max_step[i]) {
                    max2_step[i] = max_step[i];
                    max_step[i] = step;
                } else if (step > max2_step[i]) {
                    max2_step[i] = step;
                }
            }

            int ans = (int) 1e9;
            for (int i = 0; i < k; i++) {
                ans = Math.min(ans, Math.max((max_step[i] + 1) / 2, max2_step[i]));
            }
            System.out.println(ans - 1);
        }

    }
}
