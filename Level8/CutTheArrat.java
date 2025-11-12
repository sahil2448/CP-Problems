import java.util.*;

public class CutTheArrat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int sum = 0;
            
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
                sum += a[j];
            }
            
            if (sum % 3 == 0) {
                System.out.println("1 2");
            } else {
                System.out.println("0 0");
            }
        }
            }
}
