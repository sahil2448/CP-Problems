import java.util.*;

public class Lasers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int tt = 0; tt < t; tt++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int s = 0;
            
            for (int i = 0; i < n; i++) {
                s = sc.nextInt();
            }
            
            for (int i = 0; i < m; i++) {
                s = sc.nextInt();
            }
            
            System.out.println(n + m);
        }
        
    }
}