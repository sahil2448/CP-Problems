import java.util.*;

public class B {
    static Scanner sc = new Scanner(System.in);

    static void solve() {
        int n = sc.nextInt();
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        int[] pos = new int[n];

        // Calculate positions
        for (int i = 0; i < n-1; i++) {
            if (i > 0) {
                // Count '0's after position i+1 and '1's before position i
                pos[i] = countChar(s[i], i+1, n, '0') + countChar(s[i], 0, i, '1');
            } else {
                // For first row, only count '0's after position 1
                pos[i] = countChar(s[i], i+1, n, '0');
            }
        }

        // Build the answer array
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n-1; i++) {
            ans[pos[i]] = i + 1;
        }

        // Print the answer
        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                System.out.print(n);
            } else {
                System.out.print(ans[i]);
            }
            if (i < n-1) System.out.print(" ");
        }
        System.out.println();
    }

    // Helper function to count occurrences of a char in a string between start and end
    static int countChar(String str, int start, int end, char target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str.charAt(i) == target) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}

/*
    Intuition:
    - The graph is encoded by a hidden permutation p, where vertices with smaller values in p
      connect to vertices with larger values.
    - The degree of a vertex (number of edges) directly correlates with its value in the permutation:
      Higher degree → Smaller value in p.
    - Sorting vertices by their degrees allows us to reconstruct the permutation.

    Approach:
    1. Compute the degree of each vertex by counting the number of '1's in its row of the adjacency matrix.
    2. Sort vertices based on their degrees in descending order.
    3. Assign permutation values based on the sorted order:
       - Vertex with the highest degree gets the smallest value (1).
       - Vertex with the second-highest degree gets the second smallest value (2), and so on.

    Time Complexity (TC):
    - Calculating degrees: O(n^2) (summing rows of the matrix).
    - Sorting vertices: O(n log n).
    - Total: O(n^2) per test case (fast enough given constraints).

    Space Complexity (SC):
    - O(n) for storing degrees and the permutation array.
    - Overall: O(n) per test case.
*/
