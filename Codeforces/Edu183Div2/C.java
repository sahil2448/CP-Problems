
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int countA = 0, countB = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') {
                    countA++;
                } else {
                    countB++;
                }
            }

            if (countA == countB) {
                out.append(0).append('\n');
                continue;
            }

            int D = countA - countB;
            HashMap<Integer, Integer> first = new HashMap<>();
            first.put(0, 0);
            int prefix = 0;
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                prefix += (s.charAt(i) == 'a') ? 1 : -1;
                int need = prefix - D;
                Integer l = first.get(need);
                if (l != null) {
                    int len = (i + 1) - l;
                    if (len < best) {
                        best = len;
                    }
                }
                if (!first.containsKey(prefix)) {
                    first.put(prefix, i + 1);
                }
            }

            if (best == Integer.MAX_VALUE || best == n) {
                out.append(-1).append('\n');
            } else {
                out.append(best).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}
