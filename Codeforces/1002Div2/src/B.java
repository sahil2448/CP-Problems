import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int minCost = Integer.MAX_VALUE;

            for (int i = 0; i < (1 << (n - 1)); i++) {
                if (Integer.bitCount(i) != k - 1) continue;

                int[] b = new int[0];
                int subarrayIndex = 0;
                int start = 0;

                for (int j = 0; j < n - 1; j++) {
                    if ((i & (1 << j)) != 0) {
                        if (subarrayIndex % 2 != 0) {
                            b = concatenate(b, Arrays.copyOfRange(a, start, j + 1));
                        }
                        start = j + 1;
                        subarrayIndex++;
                    }
                }

                if (subarrayIndex % 2 != 0) {
                    b = concatenate(b, Arrays.copyOfRange(a, start, n));
                }

                b = concatenate(b, new int[]{0});

                int cost = b.length;

                for (int j = 0; j < b.length; j++) {
                    if (b[j] != j + 1) {
                        cost = j + 1;
                        break;
                    }
                }
                minCost = Math.min(minCost, cost);
            }
            System.out.println(minCost);
        }
        sc.close();
    }

    private static int[] concatenate(int[] arr1, int[] arr2) {
        int[] result = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }
}