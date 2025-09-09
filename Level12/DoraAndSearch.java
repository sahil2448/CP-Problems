
import java.util.*;

public class DoraAndSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }

            int[] sample = new int[n];
            for (int i = 0; i < n; i++) {
                sample[i] = i + 1;
            }

            int i = 0, j = n - 1;
            int p = 0, q = n - 1;

            while (i < j) {
                if (input[i] == sample[p]) {
                    i++;
                    p++;
                } else if (input[i] == sample[q]) {
                    i++;
                    q--;
                } else if (input[j] == sample[p]) {
                    j--;
                    p++;
                } else if (input[j] == sample[q]) {
                    j--;
                    q--;
                } else {
                    break;
                }
            }

            if (i < j) {
                System.out.println((i + 1) + " " + (j + 1));
            } else {
                System.out.println(-1);
            }
        }
    }
}
