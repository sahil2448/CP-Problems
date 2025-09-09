
import java.util.*;

public class FunwithEvenSubarrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }

            if (n == 1) {
                System.out.println(0);
                continue;
            }
            if (n == 2) {
                System.out.println(a[0] == a[1] ? 0 : 1);
                continue;
            }

            int target = a[n - 1];
            int len = 1;
            int ops = 0;

            while (len < n) {
                if (a[n - len - 1] == target) {
                    len++;
                } else {

                    ops++;
                    len *= 2; // Double the length of the subarray
                }
            }
            System.out.println(ops);
        }
    }
}

// CODE EXPLAINATION :-
// Let x = a[n-1].
// Keep a variable len – the length of the suffix that already consists of
// only x. Initially len = 1.
// While this suffix is shorter than the whole array (len < n)
// If the element just to the left of the suffix is also x
// (a[n-len-1] == x) we can simply extend the suffix (len++).
// That costs no operation.
// Otherwise we have to perform one operation: copy the whole suffix on top
// of the previous len elements.
// After that, every element in that segment becomes x and the length of
// the “good” suffix doubles (len *= 2).
// We add 1 to the answer.
// This greedy procedure is optimal and works in O(n) time and O(1) extra
// memory.

