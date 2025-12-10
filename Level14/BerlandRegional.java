
import java.util.*;

public class BerlandRegional {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] uni = new int[n];
            long[] skill = new long[n];

            for (int i = 0; i < n; i++) {
                uni[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                skill[i] = sc.nextLong();
            }

            Map<Integer, ArrayList<Long>> groups = new HashMap<>();
            for (int i = 0; i < n; i++) {
                groups.computeIfAbsent(uni[i], k -> new ArrayList<>()).add(skill[i]);
            }

            ArrayList<ArrayList<Long>> sortedGroups = new ArrayList<>();
            for (ArrayList<Long> g : groups.values()) {
                g.sort(Collections.reverseOrder());
                sortedGroups.add(g);
            }

            long[] ans = new long[n];

            for (ArrayList<Long> g : sortedGroups) {
                int sz = g.size();
                long[] pref = new long[sz];
                pref[0] = g.get(0);
                for (int i = 1; i < sz; i++) {
                    pref[i] = pref[i - 1] + g.get(i);
                }

                for (int k = 1; k <= sz; k++) {
                    int full = (sz / k) * k;
                    if (full == 0) {
                        continue;
                    }
                    ans[k - 1] += pref[full - 1];
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
