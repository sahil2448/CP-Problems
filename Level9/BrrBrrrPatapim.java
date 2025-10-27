
import java.util.*;

public class BrrBrrrPatapim {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int result[] = new int[2 * n];
            int matrix[][] = new int[n][n];
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    set.add(matrix[i][j]);
                    int ele = matrix[i][j];
                    int pos = i + j + 2;
                    result[pos - 1] = ele;
                }
            }
            for (int i = 1; i <= 2 * n; i++) {
                if (!set.contains(i)) {
                    result[0] = i;
                    break;
                }
            }

            for (int i = 0; i < 2 * n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();

        }
    }
}
