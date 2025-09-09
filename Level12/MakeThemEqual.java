
import java.util.*;

public class MakeThemEqual {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);

            String s = sc.next();

            boolean check = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != c) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println(0);
                continue;
            }

            int val = -1;

            for (int i = 2; i <= n; i++) {
                boolean isPoss = true;

                for (int j = i; j <= n; j += i) {
                    if (s.charAt(j - 1) != c) {
                        isPoss = false;

                        break;
                    }
                }

                if (isPoss) {
                    val = i;
                    break;
                }
            }

            if (val != -1) {
                System.out.println(1);
                System.out.println(val);
                continue;
            }

            System.out.println(2);
            System.out.println(n - 1 + " " + n);
        }
    }
}
