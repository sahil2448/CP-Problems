import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b = sc.nextInt();


            boolean[][] dp = new boolean[n][2];

            dp[0][0] = true;
            dp[0][1] = true;

            for (int i = 1; i < n; i++) {
                if (dp[i-1][0]) {
                    if (a[i - 1] <= a[i]) {
                        dp[i][0] = true;
                    }
                    if (a[i - 1] <= b - a[i]) {
                        dp[i][1] = true;
                    }
                }
                if (dp[i-1][1]) {
                    if (b - a[i - 1] <= a[i]) {
                        dp[i][0] = true;
                    }
                    if (b - a[i - 1] <= b - a[i]) {
                        dp[i][1] = true;
                    }
                }
            }

            if (dp[n - 1][0] || dp[n - 1][1]) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
