
import java.util.*;

public class GroupingIncreases {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int ans = 0;
            int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE; // O(1) space

            for (int i = 0; i < n; i++) { // O(n) time
                if (x > y) {
                    int temp = y;
                    y = x;
                    x = temp;
                }
                //x <= y
                if (a[i] <= x) // Case 1
                {
                    x = a[i];
                } else if (a[i] <= y) { // Case 3
                    y = a[i];
                } else { // Case 2
                    x = a[i];
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

}
