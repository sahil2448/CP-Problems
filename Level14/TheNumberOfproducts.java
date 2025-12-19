
import java.io.*;
import java.util.*;

public class TheNumberOfproducts {

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        long evenCount = 1;   // count of prefixes with even number of negatives (includes empty prefix)
        long oddCount = 0;    // count of prefixes with odd number of negatives
        boolean isEven = true; // current prefix parity (true = even number of negatives)
        long positiveSubarrays = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                isEven = !isEven; // flip parity if current element is negative
            }
            if (isEven) {
                positiveSubarrays += evenCount; // pairing with previous even prefixes
                evenCount++;
            } else {
                positiveSubarrays += oddCount;  // pairing with previous odd prefixes
                oddCount++;
            }
        }

        long totalSubarrays = 1L * n * (n + 1) / 2;
        long negativeSubarrays = totalSubarrays - positiveSubarrays;

        System.out.println(negativeSubarrays + " " + positiveSubarrays);
    }

    static class FastScanner {

        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return -1;
                }
                st = new StringTokenizer(line);
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    // Total subarrays = n * (n + 1) / 2
    // Negative = total - positive, Positive = ans
}
