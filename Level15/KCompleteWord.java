
import java.io.*;
import java.util.*;

public class KCompleteWord {

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
        long totalExecutionTime = 0;
        int t = sc.nextInt();
        while (t-- > 0) {
            long caseStartTime = System.currentTimeMillis();

            solve();
            long caseEndTime = System.currentTimeMillis();
            totalExecutionTime += (caseEndTime - caseStartTime);
        }
        out.flush();

        // System.err.println("Total Execution Time: " + totalExecutionTime + " ms");
    }

    static boolean isPalindrom(char a[]) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            if (a[i] != a[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static class DSU {

        int[] p;

        DSU(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = -1;

            }
        }

        int find(int x) {
            return p[x] < 0 ? x : (p[x] = find(p[x]));
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) {
                return false;
            }
            if (p[a] > p[b]) {
                int t = a;
                a = b;
                b = t;
            }
            p[a] += p[b];
            p[b] = a;
            return true;
        }

        int size(int x) {
            return -p[find(x)];
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        DSU dsu = new DSU(n);

        for (int i = 0; i + k < n; i++) {
            dsu.union(i, i + k);
        }
        for (int i = 0; i < n; i++) {
            dsu.union(i, n - 1 - i);
        }

        HashMap<Integer, int[]> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            int[] arr = freqMap.get(root);
            if (arr == null) {
                arr = new int[26];
                freqMap.put(root, arr);
            }
            arr[s.charAt(i) - 'a']++;
        }

        int ans = 0;
        for (int[] arr : freqMap.values()) {
            int sum = 0, mx = 0;
            for (int v : arr) {
                sum += v;
                if (v > mx) {
                    mx = v;

                }
            }
            ans += (sum - mx);
        }
        System.out.println(ans);

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
