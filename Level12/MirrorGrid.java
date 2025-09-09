
import java.util.*;

public class MirrorGrid {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            char[][] grid = new char[n][n];

            for (int i = 0; i < n; i++) {
                String row = sc.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = row.charAt(j); 
                }
            }

            int ans = 0;
            // For each cell in top-left quadrant
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    // Collect 4 symmetrical positions
                    char a = grid[i][j];
                    char b = grid[j][n - 1 - i];
                    char c = grid[n - 1 - i][n - 1 - j];
                    char d = grid[n - 1 - j][i];

                    int ones = 0;
                    if (a == '1') {
                        ones++;
                    }
                    if (b == '1') {
                        ones++;
                    }
                    if (c == '1') {
                        ones++;
                    }
                    if (d == '1') {
                        ones++;
                    }

                    // You can flip any to make all same, minimum is min(ones, 4 - ones)
                    ans += Math.min(ones, 4 - ones);
                }
            }
            System.out.println(ans);
        }
    }
}
