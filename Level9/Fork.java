
import java.util.*;

public class Fork {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x_king = sc.nextLong();
            long y_king = sc.nextLong();
            long x_queen = sc.nextLong();
            long y_queen = sc.nextLong();

            Set<String> king_hits = new HashSet<>();
            Set<String> queen_hits = new HashSet<>();

            int[] dx = {1, 1, -1, -1};
            int[] dy = {1, -1, 1, -1};

            for (int j = 0; j < 4; j++) {
                king_hits.add((x_king + dx[j] * a) + "," + (y_king + dy[j] * b));
                king_hits.add((x_king + dx[j] * b) + "," + (y_king + dy[j] * a));

                queen_hits.add((x_queen + dx[j] * a) + "," + (y_queen + dy[j] * b));
                queen_hits.add((x_queen + dx[j] * b) + "," + (y_queen + dy[j] * a));
            }

            int ans = 0;
            for (String position : king_hits) {
                if (queen_hits.contains(position)) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
        sc.close();
    }
}
