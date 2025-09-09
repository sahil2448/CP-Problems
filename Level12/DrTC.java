
import java.util.*;

public class DrTC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int countOnes = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    countOnes++;
                }
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    ans += countOnes - 1;
                } else {
                    ans += countOnes + 1;
                }
            }

            System.out.println(ans);
        }
    }
}
