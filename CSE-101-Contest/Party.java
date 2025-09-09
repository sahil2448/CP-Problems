
import java.io.*;
import java.util.*;

public class Party {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(nm.nextToken());
            int m = Integer.parseInt(nm.nextToken());

            int[] k = new int[n];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                k[i] = Integer.parseInt(stk.nextToken());
            }

            long[] c = new long[m + 1];
            StringTokenizer stc = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                c[j] = Long.parseLong(stc.nextToken());
            }

            Arrays.sort(k);
            long totalCost = 0;
            int nextPresent = 1;

            for (int idx = n - 1; idx >= 0; idx--) {
                int ki = k[idx];
                if (nextPresent <= ki && c[nextPresent] < c[ki]) {
                    totalCost += c[nextPresent];
                    nextPresent++;
                } else {
                    totalCost += c[ki];
                }
            }

            output.append(totalCost).append('\n');
        }
        System.out.print(output);
    }
}
