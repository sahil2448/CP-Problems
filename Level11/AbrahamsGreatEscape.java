
import java.util.*;

public class AbrahamsGreatEscape {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (n * n - 1 == k) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                String s = "";

                for (int j = 0; j < n; j++) {
                    if (k > 0) {
                        s += "U";
                        k = k - 1;
                    } else if (i == n - 1 && j == n - 1) {
                        s += "L";
                    } else if (i == n - 1) {
                        s += "R";
                    } else {
                        s += "D";
                    }
                }
                System.out.println(s);
            }

        }
    }
}
