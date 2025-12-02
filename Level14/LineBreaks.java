
import java.util.*;

public class LineBreaks {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int ans = 0;
            int mNew = m;

            for (int i = 0; i < n; i++) {
                String s = sc.next();
                mNew -= s.length();
                if (mNew >= 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
