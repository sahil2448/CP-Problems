
import java.util.Scanner;

public class ArrayColoring { // time complexity: O(n)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int countOdd = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 != 0) {
                    countOdd++;
                }
            }

            if (countOdd % 2 != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
