
import java.util.*;

public class YetAnotherProblemAboutPairsAnInequality {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            List<Integer> idx = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] < i + 1) {
                    idx.add(i + 1);
                }
            }

            long ans = 0;
            for (int k = 0; k < idx.size(); k++) {
                int j = idx.get(k);
                int key = (int) a[j - 1];
                int pos = Collections.binarySearch(idx, key);
                if (pos < 0) {
                    pos = -pos - 1;
                }
                ans += pos;
            }
            System.out.println(ans);
        }
    }
}
