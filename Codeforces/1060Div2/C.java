
import java.io.*;
import java.util.*;

public class C {

    static final int MAXA = 200000;
    static final int LIM = MAXA + 1; // need up to ai+1
    static int[] spf = new int[LIM + 1];
    static int[] cntA = new int[LIM + 1];
    static int[] cntA1 = new int[LIM + 1];

    static void buildSPF() {
        for (int i = 0; i <= LIM; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= LIM; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= LIM; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    static void addDistinctPrimeFactors(int x, int[] cnt, ArrayList<Integer> touched, boolean[] seenKey) {
        while (x > 1) {
            int p = spf[x];
            if (!seenKey[p]) { // first time seeing p in this test (either array)
                seenKey[p] = true;
                touched.add(p);
            }
            cnt[p]++;
            while (x % p == 0) {
                x /= p;
            }
        }
    }

    static void addDistinctPrimeFactorsNoCount(int x, ArrayList<Integer> primes) {
        while (x > 1) {
            int p = spf[x];
            primes.add(p);
            while (x % p == 0) {
                x /= p;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        buildSPF();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }
            }
            {
                br.readLine();
            }

            ArrayList<Integer> keys = new ArrayList<>();
            boolean[] seenKey = new boolean[LIM + 1];

            // Count primes dividing a[i]
            for (int i = 0; i < n; i++) {
                int x = a[i];
                // factor distinct primes of a[i]
                int y = x;
                int lastP = -1;
                while (y > 1) {
                    int p = spf[y];
                    if (p != lastP) {
                        if (!seenKey[p]) {
                            seenKey[p] = true;
                            keys.add(p);
                        }
                        cntA[p]++;
                        lastP = p;
                    }
                    y /= p;
                }
            }

            // Count primes dividing a[i]+1
            for (int i = 0; i < n; i++) {
                int x1 = a[i] + 1;
                int y = x1;
                int lastP = -1;
                while (y > 1) {
                    int p = spf[y];
                    if (p != lastP) {
                        if (!seenKey[p]) {
                            seenKey[p] = true;
                            keys.add(p);
                        }
                        cntA1[p]++;
                        lastP = p;
                    }
                    y /= p;
                }
            }

            int ans = 2;
            // Check cost 0
            for (int p : keys) {
                if (cntA[p] >= 2) {
                    ans = 0;
                    break;
                }
            }
            // Check cost 1
            if (ans != 0) {
                for (int p : keys) {
                    if (cntA[p] >= 1 && cntA1[p] >= 1) {
                        ans = 1;
                        break;
                    }
                }
            }

            out.append(ans).append('\n');

            // cleanup counts
            for (int p : keys) {
                cntA[p] = 0;
                cntA1[p] = 0;
                seenKey[p] = false; // not strictly needed since seenKey is per-test array
            }
        }

        System.out.print(out.toString());
    }
}
