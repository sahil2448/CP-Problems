
import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n + 1];
            int[] pos = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
                pos[p[i]] = i;
            }

            String xStr = sc.next();
            char[] x = xStr.toCharArray();

            if (x[0] == '1' || x[n - 1] == '1') {
                System.out.println(-1);
                continue;
            }

            List<Integer> targets = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (x[i - 1] == '1') {
                    targets.add(i);
                }
            }

            if (targets.isEmpty()) {
                System.out.println(0);
                continue;
            }

            List<int[]> operations = new ArrayList<>();
            boolean[] covered = new boolean[n + 1];

            int minIdx = pos[1];
            int maxIdx = pos[n];

            if (minIdx != maxIdx) {
                int l = Math.min(minIdx, maxIdx);
                int r = Math.max(minIdx, maxIdx);
                operations.add(new int[]{l, r});

                int minVal = 1;
                int maxVal = n;
                for (int i = l + 1; i < r; i++) {
                    if (p[i] > minVal && p[i] < maxVal) {
                        covered[i] = true;
                    }
                }
            }

            for (int target : targets) {
                if (covered[target]) {
                    continue;
                }

                int left = -1;
                for (int i = 1; i < target; i++) {
                    if (p[i] < p[target]) {
                        left = i;
                        break;
                    }
                }

                int right = -1;
                for (int i = target + 1; i <= n; i++) {
                    if (p[i] > p[target]) {
                        right = i;
                        break;
                    }
                }

                if (left != -1 && right != -1 && operations.size() < 5) {
                    operations.add(new int[]{left, right});
                    int minVal = Math.min(p[left], p[right]);
                    int maxVal = Math.max(p[left], p[right]);
                    for (int i = left + 1; i < right; i++) {
                        if (p[i] > minVal && p[i] < maxVal) {
                            covered[i] = true;
                        }
                    }
                }
            }

            boolean allCovered = true;
            for (int target : targets) {
                if (!covered[target]) {
                    allCovered = false;
                    break;
                }
            }

            if (!allCovered || operations.size() > 5) {
                System.out.println(-1);
            } else {
                System.out.println(operations.size());
                for (int[] op : operations) {
                    System.out.println(op[0] + " " + op[1]);
                }
            }
        }
    }
}
