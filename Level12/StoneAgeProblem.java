
import java.util.*;

public class StoneAgeProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] a = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        int globalValue = -1;
        Map<Integer, Integer> overrides = new HashMap<>();

        for (int query = 0; query < q; query++) {
            int t = sc.nextInt();
            if (t == 1) {
                int i = sc.nextInt() - 1;
                int x = sc.nextInt();

                int oldVal = overrides.containsKey(i)
                        ? overrides.get(i)
                        : (globalValue == -1 ? a[i] : globalValue);

                sum = sum - oldVal + x;
                overrides.put(i, x);

                System.out.println(sum);

            } else if (t == 2) {
                int x = sc.nextInt();
                globalValue = x;
                overrides.clear();

                sum = (long) x * n;
                System.out.println(sum);
            }
        }
    }
}
