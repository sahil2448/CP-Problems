
import java.util.*;

public class CollectingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();

            ArrayList<ArrayList<Long>> v = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                ArrayList<Long> pair = new ArrayList<>();
                pair.add(a);
                pair.add((long) i);
                v.add(pair);
            }

            long[] pre = new long[(int) n];

            Collections.sort(v, (list1, list2)
                    -> Long.compare(list1.get(0), list2.get(0)));

            pre[0] = v.get(0).get(0);
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + v.get(i).get(0);
            }

            long[] ans = new long[(int) n];

            for (int i = 0; i < n; i++) {
                int j = i;
                int found = i;

                while (j < n) {
                    long target = pre[j] + 1;
                    int idx = lowerBound(v, target) - 1;

                    if (idx == j) {
                        break;
                    }
                    found += idx - j;
                    j = idx;
                }
                ans[v.get(i).get(1).intValue()] = found;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    public static int lowerBound(ArrayList<ArrayList<Long>> v, long target) {
        int left = 0, right = v.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (v.get(mid).get(0) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
