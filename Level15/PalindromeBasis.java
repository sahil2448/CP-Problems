import java.io.*;
import java.util.*;

public class P {
	static final int MOD = 1_000_000_007; // required modulo
	static final int N = 40000 + 5; // max n + small buffer

	static boolean isPal(int n) {
		String s = Integer.toString(n); // convert to string
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false; // mismatch => not palindrome
			i++; j--;
		}
		return true; // all mirrored characters matched
	}

	public static void main(String[] args) throws Exception {
		FastScanner fs = new FastScanner(System.in);

		List<Integer> pal = new ArrayList<>(); // all palindromic "coins"
		for (int i = 1; i < N; i++) {
			if (isPal(i)) pal.add(i); // keep only palindromic integers
		}

		int[] dp = new int[N];
		dp[0] = 1; // one way to form sum 0 (empty multiset)

		for (int c : pal) { // unbounded knapsack (combinations)
			for (int x = c; x < N; x++) {
				dp[x] += dp[x - c]; // use coin c
				if (dp[x] >= MOD) dp[x] -= MOD; // fast modulo
			}
		}

		int t = fs.nextInt();
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = fs.nextInt();
			out.append(dp[n]).append('\n'); // precomputed answer
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
				if (line == null) return null;
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
