import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                bw.write("-1\n");
                continue;
            }

            long totalSum = (long) n * (n + 1) / 2;
            Set<Long> squares = new HashSet<>();
            for (long x = 1; x * x <= totalSum; x++) {
                squares.add(x * x);
            }

            if (squares.contains(totalSum)) {
                bw.write("-1\n");
                continue;
            }

            boolean[] used = new boolean[n + 1];
            int[] permutation = new int[n];
            long currentSum = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int chosen = -1;
                for (int num = 1; num <= n; num++) {
                    if (!used[num] && !squares.contains(currentSum + num)) {
                        chosen = num;
                        break;
                    }
                }
                if (chosen == -1) {
                    possible = false;
                    break;
                }
                used[chosen] = true;
                permutation[i] = chosen;
                currentSum += chosen;
            }

            if (possible) {
                for (int num : permutation) {
                    bw.write(num + " ");
                }
                bw.write("\n");
            } else {
                bw.write("-1\n");
            }
        }

        bw.flush();
    }
}