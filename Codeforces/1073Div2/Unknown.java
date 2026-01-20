import java.util.*;

public class Unknown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            int maxOdd = 0, countOdd = 0;
            for (int i = 1; i < n; i += 2) {
                maxOdd = Math.max(maxOdd, a[i]);
                countOdd++;
            }
            int scoreOdd = maxOdd + countOdd;
            
            int maxEven = 0, countEven = 0;
            for (int i = 0; i < n; i += 2) {
                maxEven = Math.max(maxEven, a[i]);
                countEven++;
            }
            int scoreEven = maxEven + countEven;
            
            System.out.println(Math.max(scoreOdd, scoreEven));
        }
     }
}
