import java.util.*;

public class OlympiadDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] cnt = new int[10];
            boolean f = false;
            
            for (int i = 0; i < n; i++) {
                int dig = sc.nextInt();
                cnt[dig]++;
                if (cnt[0] >= 3 && cnt[1] >= 1 && cnt[2] >= 2 &&
                    cnt[3] >= 1 && cnt[5] >= 1 && !f) {
                    System.out.println(i + 1);
                    f = true;
                }
            }
            if (!f) System.out.println(0);
        }
        
    }
}