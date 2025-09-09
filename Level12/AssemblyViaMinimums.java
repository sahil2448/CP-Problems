
import java.util.*;

public class AssemblyViaMinimums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int m = (n * (n - 1)) / 2;

            int[] v = new int[m];
            for (int i = 0; i < m; i++) {
                v[i] = sc.nextInt();
            }

            Arrays.sort(v); // O(m log m)

            int x = n - 1, i = 0;

            while (x > 0) {
                System.out.print(v[i] + " ");

                i += x;
                x--;
            } // O(n)

            System.out.println("1000000000");
        }

    }
}

// Total time complexity : O(m log m)
// Total space complexity : O(m)
