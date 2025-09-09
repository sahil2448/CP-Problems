
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (tt-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[][] v = new int[n][m];
            int[][] u = new int[n][m];
            int[][] r = new int[n][m];
            int totalG = 0;

            for (int i = 0; i < n; i++) {
                String line = sc.next();
                for (int j = 0; j < m; j++) {
                    char c = line.charAt(j);
                    if (c == '.') {
                        u[i][j] = 1;
                    } else if (c == 'g') {
                        r[i][j] = 1;
                        v[i][j] = 1;
                        totalG++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    v[i][j] += v[i][j - 1];
                }
            }

            k--;
            long ans = Long.MAX_VALUE;

            for (int i = 0; i < n && ans > 0; i++) {
                for (int j = 0; j < m && ans > 0; j++) {
                    if (u[i][j] == 0) {
                        continue;
                    }
                    long s = 0;
                    int rowStart = Math.max(0, i - k);
                    int rowEnd = Math.min(n - 1, i + k);
                    int colStartBase = j - k;
                    int colEndBase = j + k;
                    for (int z = rowStart; z <= rowEnd; z++) {
                        int x = Math.max(0, colStartBase);
                        int y = Math.min(m - 1, colEndBase);
                        s += v[z][y] - (x > 0 ? v[z][x - 1] : 0);
                    }
                    ans = Math.min(ans, s);
                }
            }

            long res = totalG - ans;
            sb.append(res).append('\n');
        }
        System.out.print(sb.toString());
        sc.close();
    }
}
