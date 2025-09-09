import java.util.*;

public class NumbersBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            int negCount = 0;
            int minAbs = Integer.MAX_VALUE;
            long absSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                    if (grid[i][j] < 0) negCount++;
                    int absVal = Math.abs(grid[i][j]);
                    absSum += absVal;
                    if (absVal < minAbs) minAbs = absVal;
                }
            }

            if (negCount % 2 == 0) {
                System.out.println(absSum);
            } else {
                System.out.println(absSum - 2 * minAbs);
            }
        }
    }
}
