
import java.util.*;

public class ThreeActivities {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<long[]> aList = new ArrayList<>();
            List<long[]> bList = new ArrayList<>();
            List<long[]> cList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                aList.add(new long[]{val, i});
            }
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                bList.add(new long[]{val, i});
            }
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                cList.add(new long[]{val, i});
            }

            Collections.sort(aList, (x, y) -> Long.compare(y[0], x[0]));
            Collections.sort(bList, (x, y) -> Long.compare(y[0], x[0]));
            Collections.sort(cList, (x, y) -> Long.compare(y[0], x[0]));

            // Take the top 3 elements from each list (if the list has at least 3 elements)
            List<long[]> topA = aList.subList(0, Math.min(3, aList.size()));
            List<long[]> topB = bList.subList(0, Math.min(3, bList.size()));
            List<long[]> topC = cList.subList(0, Math.min(3, cList.size()));

            long maxSum = 0;
            for (long[] x : topA) {
                for (long[] y : topB) {
                    for (long[] z : topC) {
                        if (x[1] != y[1] && x[1] != z[1] && y[1] != z[1]) {
                            long sum = x[0] + y[0] + z[0];
                            if (sum > maxSum) {
                                maxSum = sum;
                            }
                        }
                    }
                }
            }
            System.out.println(maxSum);
        }
    }
}
