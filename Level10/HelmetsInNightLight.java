import java.util.*;

public class HelmetsInNightLight {
    static class Pair implements Comparable<Pair> {
        long b, a;
        Pair(long b, long a) { this.b = b; this.a = a; }
        public int compareTo(Pair o) {
            return Long.compare(this.b, o.b);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long p = sc.nextLong();
            
            long[] a = new long[n], b = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            for (int i = 0; i < n; i++) b[i] = sc.nextLong();
            
            Pair[] v = new Pair[n];
            for (int i = 0; i < n; i++) {
                v[i] = new Pair(b[i], a[i]);
            }
            Arrays.sort(v);  
            
            long rem = n - 1;      
            long cost = p;         
            
            for (int i = 0; i < n && rem > 0; i++) {
                if (v[i].b >= p) break;          
                long use = Math.min(rem, v[i].a);
                cost += use * v[i].b;
                rem -= use;
            }
            cost += rem * p;
            
            System.out.println(cost);
        }
        sc.close();
    }
}
