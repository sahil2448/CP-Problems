
import java.io.*;

public class AddModuloTen {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sc = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] parts = br.readLine().split(" ");
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(parts[i]);
                // Make odd numbers even in one operation
                if (a[i] % 2 == 1) {
                    a[i] += a[i] % 10;
                }
            }

            boolean allEqual = true;
            for (int i = 1; i < n; i++) {
                if (a[i] != a[0]) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                sc.append("YES\n");
                continue;
            }

            boolean stuckWithZero = false;
            for (int x : a) {
                if (x % 10 == 0) { // cannot change further
                    stuckWithZero = true;
                    break;
                }
            }
            if (stuckWithZero) {
                sc.append("NO\n");
                continue;
            }

            // Transform numbers to residue modulo 20 by driving last digit to 2
            for (int i = 0; i < n; i++) {
                while (a[i] % 10 != 2) {
                    a[i] += a[i] % 10;
                }
                a[i] %= 20;
            }

            allEqual = true;
            for (int i = 1; i < n; i++) {
                if (a[i] != a[0]) {
                    allEqual = false;
                    break;
                }
            }

            sc.append(allEqual ? "YES\n" : "NO\n");
        }

        System.out.print(sc);
    }
}
// Time Complexity (TC): O(n)
// Space Complexity (SC): O(1)
