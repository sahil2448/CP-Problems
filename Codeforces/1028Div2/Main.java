import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 998244353;
    static long[] pow2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        pow2 = new long[100001];
        pow2[0] = 1;
        for (int i = 1; i <= 100000; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] p = new int[n];
            String[] tokens = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(tokens[i]);
            }
            
            int[] q = new int[n];
            tokens = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                q[i] = Integer.parseInt(tokens[i]);
            }
            
            PriorityQueue<int[]> heapA = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            PriorityQueue<int[]> heapB = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            long[] ans = new long[n];
            
            for (int i = 0; i < n; i++) {
                if (heapA.size() < 100) {
                    heapA.offer(new int[]{p[i], i});
                } else {
                    if (p[i] > heapA.peek()[0]) {
                        heapA.poll();
                        heapA.offer(new int[]{p[i], i});
                    }
                }
                
                if (heapB.size() < 100) {
                    heapB.offer(new int[]{q[i], i});
                } else {
                    if (q[i] > heapB.peek()[0]) {
                        heapB.poll();
                        heapB.offer(new int[]{q[i], i});
                    }
                }
                
                int best_max = -1;
                int best_min = -1;
                
                for (int[] node : heapA) {
                    int j = node[1];
                    int k = i - j;
                    if (k >= 0 && k < n) {
                        int a = node[0];
                        int b = q[k];
                        int mx = Math.max(a, b);
                        int mn = Math.min(a, b);
                        if (best_max == -1) {
                            best_max = mx;
                            best_min = mn;
                        } else {
                            if (mx > best_max || (mx == best_max && mn > best_min)) {
                                best_max = mx;
                                best_min = mn;
                            }
                        }
                    }
                }
                
                for (int[] node : heapB) {
                    int k = node[1];
                    int j = i - k;
                    if (j >= 0 && j < n) {
                        int a = p[j];
                        int b = node[0];
                        int mx = Math.max(a, b);
                        int mn = Math.min(a, b);
                        if (best_max == -1) {
                            best_max = mx;
                            best_min = mn;
                        } else {
                            if (mx > best_max || (mx == best_max && mn > best_min)) {
                                best_max = mx;
                                best_min = mn;
                            }
                        }
                    }
                }
                
                ans[i] = (pow2[best_max] + pow2[best_min]) % MOD;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(' ');
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
    }
}