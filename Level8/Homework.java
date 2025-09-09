
import java.util.*;

public class Homework {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            int m = sc.nextInt();
            String b = sc.next();
            String c = sc.next();

            StringBuilder sb = new StringBuilder(a);

            for (int i = 0; i < m; i++) {
                if (c.charAt(i) == 'D') {
                    sb.append(b.charAt(i));
                } else {
                    sb.insert(0, b.charAt(i));
                }
            }

            System.out.println(sb.toString());
        }
    }
}
