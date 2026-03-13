
import java.io.*;
import java.util.*;

public class PalindromBasis {

    static final int MOD = 1_000_000_007;
    static final int N = 40000 + 5;

    static boolean isPal(int n) {
        String s = Integer.toString(n);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;

            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        List<Integer> pal = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (isPal(i)) {
                pal.add(i);

            }
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for (int c : pal) {
            for (int x = c; x < N; x++) {
                dp[x] += dp[x - c];
                if (dp[x] >= MOD) {
                    dp[x] -= MOD;

                }
            }
        }

        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = fs.nextInt();
            out.append(dp[n]).append('\n');
        }
        System.out.print(out.toString());
    }

    static class FastScanner {

        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

/*
Time Complexity (TC): O(sz * N + t) -> O(1e3 * 4e4)
Space Complexity (SC) : O(N + t)
 */
