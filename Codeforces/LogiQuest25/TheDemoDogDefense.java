
import java.util.*;

public class TheDemoDogDefense {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int d = sc.nextInt();

        int a[] = {k, l, m, n};

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= d; i++) {
            set.add(i);
        }

        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int p = 1;

            while (num <= d) {
                if (set.contains(num)) {
                    set.remove(num);
                }
                num = p * a[i];
                p++;
            }
        }
        int sz = set.size();
        System.out.println(d - sz);

    }
}
