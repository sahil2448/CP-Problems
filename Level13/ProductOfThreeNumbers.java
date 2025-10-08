
import java.util.*;

public class ProductOfThreeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            ArrayList<Long> ans = new ArrayList<>();

            for (long i = 2; i * i <= n && ans.size() < 2; i++) {
                if (n % i == 0) {
                    ans.add(i);
                    n /= i;
                }
            }

            if (ans.size() == 2 && n > 1 && !ans.contains(n)) {
                ans.add(n);
                System.out.println("YES");
                System.out.printf("%d %d %d\n", ans.get(0), ans.get(1), ans.get(2));
            } else {
                System.out.println("NO");
            }
        }
    }
}
