
import java.util.*;

public class ScheduleManagement {

    public static boolean canFinish(int n, int m, int T, HashMap<Integer, Integer> freqMap) {
        long maxPossible = 0L;

        for (int c : freqMap.values()) {
            if (c > T) {
                maxPossible += T;
            } else {
                maxPossible += c + (T - c) / 2;
            }
        }

        int zeroWorkers = n - freqMap.size();
        if (zeroWorkers > 0) {
            maxPossible += 1L * zeroWorkers * (T / 2);
        }

        return maxPossible >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        while (tests-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int who = sc.nextInt();
                map.put(who, map.getOrDefault(who, 0) + 1);
            }

            int s = 0;
            int e = 2 * m;
            while (s < e) {
                int mid = (s + e) / 2;
                if (canFinish(n, m, mid, map)) {
                    e = mid;
                } else {
                    s = mid + 1;
                }
            }

            System.out.println(s);
        }

        sc.close();
    }
}
