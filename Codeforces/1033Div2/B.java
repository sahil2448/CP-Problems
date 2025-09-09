
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long s = sc.nextLong();

            long mat[][] = new long[(int) n][4];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    mat[i][j] = sc.nextLong();
                }
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                long dx = mat[i][0];
                long dy = mat[i][1];
                long x = mat[i][2];
                long y = mat[i][3];

                if (dx == dy && x == y) {
                    ans++;
                } else if (dx != dy && x + y == s) {
                    ans++;
                }

            }

            System.out.println(ans);

        }
    }
}
