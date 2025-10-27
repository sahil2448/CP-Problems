
import java.util.*;

public class A {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            char a[] = s.toCharArray();
            int pos = -1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == '1' && pos == -1) {
                    count++;
                    pos = i;
                } else if (a[i] == '1') {
                    int diff = i - pos;
                    if (diff >= k) {
                        count++;
                    }
                    pos = i;
                }
            }

            System.out.println(count);
        }
    }
}
