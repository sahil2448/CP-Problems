
import java.util.*;

public class MIX_MEX_MAX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                s.add(x);
            }

            s.remove(-1);

            if (s.size() <= 1 && !s.contains(0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
