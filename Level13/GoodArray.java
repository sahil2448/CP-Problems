
import java.util.*;

public class GoodArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        long totalSum = 0;
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            totalSum += a[i];

            valueToIndices.computeIfAbsent(a[i], k -> new ArrayList<>()).add(i + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long sumAfterRemoval = totalSum - a[i];

            if (sumAfterRemoval % 2 == 0) {
                long target = sumAfterRemoval / 2;

                if (target <= Integer.MAX_VALUE && valueToIndices.containsKey((int) target)) {
                    List<Integer> indices = valueToIndices.get((int) target);

                    if (target == a[i] && indices.size() >= 2) {
                        result.add(i + 1);
                    } else if (target != a[i]) {
                        result.add(i + 1);
                    }
                }
            }
        }

        System.out.println(result.size());
        for (int index : result) {
            System.out.print(index + " ");
        }
    }
}
