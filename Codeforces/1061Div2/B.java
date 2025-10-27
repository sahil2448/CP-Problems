
import java.util.*;

public class B {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.next();
            boolean hasB = s.indexOf('B') >= 0;
            for (int i = 0; i < q; i++) {
                long a = sc.nextLong();
                if (!hasB) {
                    out.append(a).append('\n');
                    continue;
                }
                long steps = 0;
                int pos = 0;
                char[] arr = s.toCharArray();
                while (a > 0) {
                    if (arr[pos] == 'A') {
                        a--;
                    } else {
                        a = a / 2;
                    }
                    steps++;
                    pos++;
                    if (pos == n) {
                        pos = 0;
                    }
                }
                out.append(steps).append('\n');
            }
        }
        System.out.print(out.toString());
    }

}
