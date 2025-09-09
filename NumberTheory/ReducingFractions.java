
import java.io.*;
import java.util.*;

public class ReducingFractions {

    static final int MOD = 1000000007;
    static final int N = 10000001;
    static int[] smallestprime = new int[N + 1];

    static long binpow(long a, long b) { // Binary Exponentiation
        
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a;
            }
            a *= a;
            b >>= 1;
        }
        return res;
    }

    static void calc() { // O(Nlog(logN)) N->10^7
        for (int i = 2; i < N; i++) {
            smallestprime[i] = i;
        }
        for (int i = 2; i < N; i++) {
            if (smallestprime[i] == i) {
                for (long j = (long) i * i; j < N; j += i) {
                    if (smallestprime[(int) j] == j) {
                        smallestprime[(int) j] = i;
                    }
                }
            }
        }
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        calc();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long[] a = new long[n];
        long[] b = new long[m];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(input[i]);
        }

        Map<Integer, Integer> numerator = new HashMap<>();
        Map<Integer, Integer> denominator = new HashMap<>();
        Map<Integer, Integer> minpower = new HashMap<>();

        for (int i = 0; i < n; i++) { // n*log(a[i])
            long x = a[i];
            while (x > 1) { // log(a[i])
                int p = smallestprime[(int) x];
                int cnt = 0;

                while (x % p == 0) {
                    cnt++;
                    x /= p;
                }
                numerator.put(p, numerator.getOrDefault(p, 0) + cnt);
            }
        }

        for (int i = 0; i < m; i++) { // m*log(b[i])
            long x = b[i];
            while (x > 1) {
                int p = smallestprime[(int) x];
                int cnt = 0;

                while (x % p == 0) {
                    cnt++;
                    x /= p;
                }
                denominator.put(p, denominator.getOrDefault(p, 0) + cnt);
            }
        }

        for (Map.Entry<Integer, Integer> entry : numerator.entrySet()) { // O(100)
            int prime = entry.getKey();
            int numCount = entry.getValue();
            int denCount = denominator.getOrDefault(prime, 0);
            minpower.put(prime, Math.min(numCount, denCount));
        }

        // Reset maps to minpower values
        numerator.clear();
        denominator.clear();
        numerator.putAll(minpower);
        denominator.putAll(minpower);

        for (int i = 0; i < n; i++) { // n*log(a[i])
            long x = a[i];
            while (x > 1) {
                int p = smallestprime[(int) x];
                int cnt = 0;

                while (x % p == 0) {
                    cnt++;
                    x /= p;
                }
                cnt = Math.min(cnt, numerator.getOrDefault(p, 0));
                numerator.put(p, numerator.get(p) - cnt);
                a[i] /= binpow(p, cnt); // log(cnt)
            }
        }

        for (int i = 0; i < m; i++) { // m*log(b[i])
            long x = b[i];
            while (x > 1) {
                int p = smallestprime[(int) x];
                int cnt = 0;

                while (x % p == 0) {
                    cnt++;
                    x /= p;
                }
                cnt = Math.min(cnt, denominator.getOrDefault(p, 0));
                denominator.put(p, denominator.get(p) - cnt);
                b[i] /= binpow(p, cnt); // log(cnt)
            }
        }

        pw.println(a.length + " " + b.length);
        for (long val : a) {
            pw.print(val + " ");
        }
        pw.println();
        for (long val : b) {
            pw.print(val + " ");
        }
        pw.println();

        pw.close();
        br.close();
    }

    // TC - (Nlog(logN) + nlog(a[i]) + mlog(b[i]))
    // SC - 10^7 + O(n+m)
    public static void main(String[] args) throws IOException {
        solve();
    }
}
