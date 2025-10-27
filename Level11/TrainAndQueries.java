
import java.util.*;

public class TrainAndQueries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            StringBuilder output = new StringBuilder("");
            int n = sc.nextInt();
            int k = sc.nextInt();

            HashMap<Long, TreeSet<Integer>> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long num = sc.nextLong();

                TreeSet<Integer> set = hm.getOrDefault(num, new TreeSet<>());
                set.add(i);
                hm.put(num, set);
            }

            for (int i = 0; i < k; i++) {
                long q1 = sc.nextLong();
                long q2 = sc.nextLong();

                if (hm.containsKey(q1) && hm.containsKey(q2)) {
                    long ft = hm.get(q1).first();
                    long lt = hm.get(q2).last();

                    if (ft <= lt) {
                        output.append("YES\n");
                    } else {
                        output.append("NO\n");
                    }
                } else {
                    output.append("NO\n");
                }
            }

            System.out.print(output.toString());
        }
    }
}
