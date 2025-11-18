
import java.util.*;

public class C {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            int maxIdx = 0;
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextLong();
                if (a[i] > a[maxIdx]) {
                    maxIdx = i;
                }
            }

            long[] b = new long[n];
            for (int i = 0; i < n; ++i) {
                b[i] = a[(maxIdx + 1 + i) % n];
            }

            long ans = 0L;
            Deque<Long> st = new ArrayDeque<>();
            st.push(Long.MAX_VALUE);

            for (int i = 0; i < n; ++i) {
                long cur = b[i];
                while (st.peek() <= cur) {
                    long mid = st.pop();
                    ans += Math.min(st.peek(), cur);
                }
                st.push(cur);
            }

            while (st.size() > 2) {
                long mid = st.pop();
                ans += st.peek();
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }

}
