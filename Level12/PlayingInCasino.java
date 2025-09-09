import java.util.*;

public class PlayingInCasino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(); // rows
            int m = sc.nextInt(); // columns

            // Storing a rotated matrix: v[m][n]
            long[][] v = new long[m][n];

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    v[i][j] = sc.nextLong();
                }
            } // O(n * m)

            for (int i = 0; i < m; i++) {
                Arrays.sort(v[i]);
            } // O(m * (n log n))

            long ans = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans -= v[i][j] * (n - j - 1);
                    ans += v[i][j] * j;
                }
            } // O(n * m)

            System.out.println(ans);
        }
    }
}

// Total time complexity : O(m * (n log n))
// Total space complexity : O(n * m)
