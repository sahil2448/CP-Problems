
import java.util.*;

public class LiHuaAndPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int matrix[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != matrix[n - i - 1][n - j - 1]) {
                        count++;
                    }
                }
            }
            count /= 2;

            if (count > k) {
                System.out.println("NO");
            } else {
                int temp = k - count;
                if (temp % 2 == 0) {
                    System.out.println("YES");
                } else {
                    if (n % 2 == 0) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }
                }
            }
        }
    }
}
