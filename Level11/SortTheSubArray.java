
import java.util.*;

public class SortTheSubArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            long[] arr2 = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = sc.nextLong();
            }

            int change1 = -1, change2 = -1;
            for (int i = 0; i < n; i++) { // finding the first l and first left;
                if (arr[i] != arr2[i]) {
                    if (change1 == -1) {
                        change1 = i;
                    } else {
                        change2 = i;
                        break;
                    }
                }
            }
            int i = change1 - 1;
            while (i >= 0) { // extending the left
                if (arr2[i] <= arr2[i + 1]) {
                    i--;
                } else {
                    break;
                }
            }
            change1 = i + 1;
            if (change2 == -1) { // if initially elements at the right  of change1 are same....then my change2 will be n-1..hence i need to assign it n-1
                change2 = n - 1;
            }
            int j = change2 + 1;
            while (j < n) { // extending rhe right
                if (arr2[j] >= arr2[j - 1]) {
                    j++;
                } else {
                    break;
                }
            }
            change2 = j - 1;
            System.out.println((change1 + 1) + " " + (change2 + 1));
        }
    }
}
