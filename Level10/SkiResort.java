import java.util.*;

public class SkiResort {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int q = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            ArrayList<Integer> indices = new ArrayList<>();
            //  -1 as a starting point
            indices.add(-1);
            
            for (int i = 0; i < n; i++) {
                if (arr[i] > q) {
                    indices.add(i);
                }
            }
            //  n as an ending point
            indices.add(n);

            long ans = 0;
            
            for (int i = 0; i < indices.size() - 1; i++) {
                int start = indices.get(i) + 1;
                int end = indices.get(i + 1) - 1;
                int segmentLength = end - start + 1;
                
                //  count segments with length >= k
                if (segmentLength >= k) {
                    ans += (long)(segmentLength - k + 1) * (segmentLength - k + 2) / 2;
                }
            }

            System.out.println(ans);
        }
        sc.close();
    }
}

// REFER THESE EXAMPLES:
// Let me explain the formula from basics:

// Understanding the Formula for Valid Vacation Periods
// For a segment of consecutive days with acceptable temperatures (≤ q), we need to count how many ways we can choose at least k consecutive days.


// Step 1: Count Ways to Choose Exactly Each Length
// Let's say we have a segment of length L (where all days have temperature ≤ q).

// For each possible vacation length from k to L:


// Ways to choose exactly k consecutive days = (L-k+1)
// Ways to choose exactly k+1 consecutive days = (L-k)
// Ways to choose exactly k+2 consecutive days = (L-k-1)
// ...
// Ways to choose exactly L consecutive days = 1
// Step 2: Sum All Possibilities
// Total ways = (L-k+1) + (L-k) + (L-k-1) + ... + 1

// This is an arithmetic sequence with:

// First term: a = (L-k+1)
// Last term: l = 1
// Number of terms: n = (L-k+1)
// Step 3: Apply the Sum Formula
// For an arithmetic sequence, the sum is:


// text

// Sum = n * (a + l) / 2

// Substituting our values:





// text

// Sum = (L-k+1) * [(L-k+1) + 1] / 2

//  = (L-k+1) * (L-k+2) / 2

// Example
// If L = 5 (segment length) and k = 3 (minimum days):


// Ways to choose exactly 3 days = 5-3+1 = 3 ways
// Ways to choose exactly 4 days = 5-4+1 = 2 ways
// Ways to choose exactly 5 days = 5-5+1 = 1 way
// Total = 3 + 2 + 1 = 6 ways

// Using our formula:



// text

// (5-3+1) * (5-3+2) / 2 = 3 * 4 / 2 = 6

// This is why we use the formula (segmentLength - k + 1) * (segmentLength - k + 2) / 2 to efficiently calculate the total number of valid vacation periods.

// Answer from Perplexity: pplx.ai/share