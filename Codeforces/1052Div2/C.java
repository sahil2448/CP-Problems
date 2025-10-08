
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = i + 1;
            }

            boolean pos = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    if (i > 0 && s.charAt(i - 1) == '0') {
                        // swap ans[i] and ans[i-1]
                        int temp = ans[i];
                        ans[i] = ans[i - 1];
                        ans[i - 1] = temp;
                    } else if (i + 1 == n || s.charAt(i + 1) != '0') {
                        pos = false;
                    }
                }
            }

            if (pos) {
                System.out.println("YES");
                for (int x : ans) {
                    System.out.print(x + " ");
                }
                System.out.println();
            } else {
                System.out.println("NO");
            }
        }
    }
}
