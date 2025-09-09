
import java.util.*;

public class ShoeShuffling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            if (n == 1) {
                System.out.println(-1);
                continue;
            }

            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }

            boolean impossible = false;
            for (int count : freq.values()) {
                if (count == 1) {
                    System.out.println(-1);
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                continue;
            }

            int[] result = new int[n];

            int i = 0; // below while loop is for segment rotation for all the segments
            while (i < n) {
                int j = i;
                while (j < n - 1 && arr[j].equals(arr[j + 1])) {
                    j++;
                }

                for (int k = i; k <= j; k++) {
                    if (k == j) {
                        result[k] = i + 1;
                    } else {
                        result[k] = k + 2;
                    }
                }

                i = j + 1;
            }

            for (int idx = 0; idx < n; idx++) {
                System.out.print(result[idx] + " ");
            }
            System.out.println();
        }
    }
}
