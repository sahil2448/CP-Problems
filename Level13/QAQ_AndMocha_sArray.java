
import java.util.*;

public class QAQ_AndMocha_sArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            boolean hasOne = false;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == 1) {
                    hasOne = true;
                }
            }

            if (hasOne) {
                System.out.println("Yes");
                continue;
            }

            Arrays.sort(a);
            ArrayList<Integer> b = new ArrayList<>();

            for (int i = 1; i < n; i++) {
                if (a[i] % a[0] != 0) {
                    b.add(a[i]);
                }
            }

            Collections.sort(b);
            boolean flag = false;

            for (int j = 1; j < b.size(); j++) {
                if (b.get(j) % b.get(0) != 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
