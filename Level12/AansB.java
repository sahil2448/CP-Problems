
import java.util.*;

public class AansB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            ArrayList<Integer> posA = new ArrayList<>();
            ArrayList<Integer> posB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'a') {
                    posA.add(i);
                } else {
                    posB.add(i);
                }
            }
            long costA = clusterCost(posA);
            long costB = clusterCost(posB);
            System.out.println(Math.min(costA, costB));
        }
    }

    static long clusterCost(ArrayList<Integer> pos) {
        int m = pos.size();
        if (m <= 1) {
            return 0L;
        }
        long[] b = new long[m];
        for (int i = 0; i < m; i++) {
            b[i] = (long) pos.get(i) - i;
        }
        long median = b[m / 2];
        long sum = 0L;
        for (int i = 0; i < m; i++) {
            sum += Math.abs(b[i] - median);
        }
        return sum;
    }
}
