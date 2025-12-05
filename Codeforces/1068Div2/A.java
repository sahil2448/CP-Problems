
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int ans = 0;
            int check = -1;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    check = i + k;
                } else {
                    if (i > check) {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
