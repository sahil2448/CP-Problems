
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            char ch = s.charAt(n - 1);

            long count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != ch) {
                    count++;
                }
            }

            System.out.println(count);

        }

    }
}
