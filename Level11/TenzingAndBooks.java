
import java.util.*;

public class TenzingAndBooks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            List<Integer>[] pre = new ArrayList[3];
            for (int i = 0; i < 3; i++) {
                pre[i] = new ArrayList<>();
                pre[i].add(0);
                int s = 0;
                for (int j = 0; j < n; j++) {
                    int ai = sc.nextInt();
                    if ((s | ai) != s) {
                        s |= ai;
                        pre[i].add(s);
                    }
                }
            }

            boolean ans = false;
            outer:
            for (int A : pre[0]) {
                for (int B : pre[1]) {
                    for (int C : pre[2]) {
                        if ((A | B | C) == x) {
                            ans = true;
                            break outer;
                        }
                    }
                }
            }

            System.out.println(ans ? "YES" : "NO");
        }

    }
}
