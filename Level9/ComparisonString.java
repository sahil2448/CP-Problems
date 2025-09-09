import java.util.*;

public class ComparisonString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            sc.nextLine(); 
            String s = sc.nextLine();

            long counter = 1;
            long ans = 0;

            if (n == 1) {
                System.out.println(2);
                continue; 
            } else {
                for (int i = 1; i < n; i++) {
                    if (s.charAt(i) == s.charAt(i - 1)) {
                        counter++;
                    } else {
                        ans = Math.max(counter, ans);
                        counter = 1; 
                    }
                }
                ans = Math.max(counter, ans);
                System.out.println(ans + 1);
            }
        }
    }
}
