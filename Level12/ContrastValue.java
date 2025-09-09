
import java.util.*;

public class ContrastValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();

            long a[] = new long[(int) n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            ArrayList<Long> ans = new ArrayList<>();

            if (n == 1) {
                System.out.println(1);
                continue;
            }

            ans.add(a[0]);
            ans.add(a[1]);

            for (int i = 2; i < n; i++) {
                int currSize = ans.size();
                long x = ans.get(currSize - 2) - ans.get(currSize - 1);
                long y = ans.get(currSize - 1) - a[i];

                if (x > 0) {
                    if (y > 0) {
                        ans.set(currSize - 1, a[i]);
                    } else if (y < 0) {
                        ans.add(a[i]);
                    }
                } else {
                    if (y < 0) {
                        ans.set(currSize - 1, a[i]);
                    } else if (y > 0) {
                        ans.add(a[i]);
                    }
                }
            }
            long totalSize = ans.size();
            if (ans.get(0).equals(ans.get(1))) {
                totalSize--;
            }
            System.out.println(totalSize);

        }

    }
}
