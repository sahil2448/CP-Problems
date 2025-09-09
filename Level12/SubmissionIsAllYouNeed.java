
import java.util.*;

public class SubmissionIsAllYouNeed {

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            ans += tmp + (tmp == 0 ? 1 : 0);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
