
import java.util.*;

public class BlackBoardGame {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            long n = sc.nextLong();
            long cnt[] = new long[4];

            for (int i = 0; i < n; i++) {
                cnt[i % 4]++;

            }

            System.out.println(cnt[0] == cnt[3] && cnt[1] == cnt[2] ? "Bob" : "Alice");
        }

    }

}
