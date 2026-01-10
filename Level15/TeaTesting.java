
import java.io.*;
import java.util.*;

public class TeaTesting {

    static final int MOD = 1000000007;
    static final int INF = (int) 1e9;
    static final long INF_LONG = (long) 1e18;

    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] arr;
    static HashMap<String, Integer> hash;

    static class Debug {

        static boolean DEBUG = System.getProperty("ONLINE_JUDGE") == null;

        public static void dbg(Object... o) {
            if (!DEBUG) {
                return;
            }
            System.err.print("[");
            for (int i = 0; i < o.length; i++) {
                if (i > 0) {
                    System.err.print(", ");
                }
                System.err.print(toString(o[i]));
            }
            System.err.println("]");
        }

        private static String toString(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof Collection<?>) {
                return obj.toString();
            }
            if (obj instanceof Map<?, ?>) {
                return obj.toString();
            }
            return obj.toString();
        }
    }

    public static void main(String[] args) throws IOException {

        int t = (int) sc.nextLong();
        while (t-- > 0) {
            int n = (int) sc.nextLong();
            long[] a = new long[n + 1];
            long[] b = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextLong();
            }

            long[] pr = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                pr[i] = pr[i - 1] + b[i]; // pr[i] = sum of b[1..i]
            }
            long[] cnt = new long[n + 2]; // difference array to count full contributions
            long[] ans = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                long x = a[i] + pr[i - 1]; // total capacity reachable before tea i runs out
                int j = upperBound(pr, x); // first index where pr[j] > x

                if (j <= n) {
                    ans[j] += x - pr[j - 1]; // partial amount the j-th taster drinks from tea i
                }
                cnt[i] += 1; // tasters in [i, j - 1] take full b[k]
                cnt[j] -= 1; // stop full contribution after j - 1 (j may be n + 1)
            }

            for (int i = 1; i <= n; i++) {
                cnt[i] += cnt[i - 1]; // apply prefix to get how many teas fully cover taster i
                ans[i] += cnt[i] * b[i]; // add full contributions
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }

    }

    private static int upperBound(long[] arr, long key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static void solve() throws IOException {

    }

    // ---------------- MODULAR ARITHMETIC ----------------
    static int modAdd(int a, int b) {
        int res = a + b;
        if (res >= MOD) {
            res -= MOD;
        }
        return res;
    }

    static int modSub(int a, int b) {
        int res = a - b;
        if (res < 0) {
            res += MOD;
        }
        return res;
    }

    static int modMul(int a, int b) {
        return (int) ((long) a * b % MOD);
    }

    static int modPow(int base, int exp) {
        int result = 1;
        int cur = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = modMul(result, cur);
            }
            cur = modMul(cur, cur);
            exp >>= 1;
        }
        return result;
    }

    static int modInv(int a) {
        return modPow(a, MOD - 2);
    }

    static int modDivide(int a, int b) {
        return modMul(a, modInv(b));
    }

    // ---------------- PREDEFINED CONSTANTS ----------------
    static int nCr(int n, int r) {
        if (r > n || r < 0) {
            return 0;
        }
        return modDivide(modMul(fact(n), 1), modMul(fact(r), fact(n - r)));
    }

    static int nPr(int n, int r) {
        if (r > n || r < 0) {
            return 0;
        }
        return modDivide(fact(n), fact(n - r));
    }

    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = modMul(res, i);
        }
        return res;
    }

    // ---------------- UTILITY METHODS ----------------
    static int[] getPrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd((int) a, (int) b) * b;
    }

    // ---------------- BINARY SEARCH HELPERS ----------------
    static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int lastLessThan(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int lastLessThanOrEqual(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // ---------------- FAST IO ----------------
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int[] readIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] readLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        String[] readStringArray(int n) throws IOException {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = next();
            }
            return arr;
        }
    }
}
