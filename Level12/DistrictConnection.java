
import java.util.*;

public class DistrictConnection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            List<int[]> result = new ArrayList<>();
            int idx = -1;

            for (int i = 1; i < n; i++) {
                if (a[i] != a[0]) {
                    idx = i;
                    result.add(new int[]{1, i + 1});
                }
            }

            if (idx == -1) {
                System.out.println("NO");
                continue;
            }

            for (int i = 1; i < n; i++) {
                if (a[i] == a[0]) {
                    result.add(new int[]{idx + 1, i + 1});
                }
            }
            System.out.println("YES");
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
            }

        }
    }
}
