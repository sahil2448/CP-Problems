
import java.io.*;

public class TwoScreens {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sc = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            while (s != null && s.length() == 0) {
                s = br.readLine();
            }
            String t = br.readLine();
            while (t != null && t.length() == 0) {
                t = br.readLine();
            }

            int n = s.length();
            int m = t.length();
            int lim = Math.min(n, m);

            int lcp = 0;
            for (int i = 0; i < lim; i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    lcp++;
                } else {
                    break;
                }
            }

            int ans = n + m - Math.max(lcp, 1) + 1;
            sc.append(ans).append('\n');
        }

        System.out.print(sc.toString());
    }
}
