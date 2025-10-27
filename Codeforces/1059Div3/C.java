
import java.util.Scanner;

public class C {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == b) {
                sb.append(0).append('\n');
                continue;
            }
            int hbA = Integer.highestOneBit(a);
            int hbB = Integer.highestOneBit(b);
            if (hbB > hbA) {
                sb.append(-1).append('\n');
                continue;
            }
            int t = a ^ b;
            if (t <= a) {
                sb.append(1).append('\n');
                sb.append(t).append('\n');
            } else {
                int x1 = hbB;
                int x2 = t ^ x1;
                sb.append(2).append('\n');
                sb.append(x1).append(' ').append(x2).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

}
