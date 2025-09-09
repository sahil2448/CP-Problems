
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Set<Integer> prev = new HashSet<>();
            Set<Integer> total = new HashSet<>();
            int partCnt = 0;

            for (int x : a) {
                total.add(x);
                if (prev.contains(x)) {
                    prev.remove(x);
                }
                // as soon as prev is empty, we can make a cut here
                if (prev.isEmpty()) {
                    partCnt++;
                    prev.clear();
                    prev.addAll(total);
                }
            }

            System.out.println(partCnt);
        }

    }
}
