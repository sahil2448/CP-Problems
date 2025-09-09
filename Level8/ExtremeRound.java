
import java.util.*;

public class ExtremeRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int finalCount = 0;
            for (int i = 1; i <= n; i++) {
                int x = i;
                int count = 0;
                while (x > 0) {
                    if (x % 10 != 0) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                    x = x/10;
                }
                if (count == 1) {
                    finalCount++;
                }
            }
            System.out.println(finalCount);
            t--;

        }
        
    }
}

