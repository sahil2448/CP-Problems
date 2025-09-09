
import java.util.*;

public class APerfectlyBalancedString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char chArr[] = s.toCharArray();

            Set<Character> set = new HashSet<>();
            int i;
            for (i = 0; i < s.length(); i++) {
                char ch = chArr[i];
                if (set.contains(ch)) {
                    break;
                } else {
                    set.add(ch);
                }
            }
            boolean isPerfectlyBalanced = true;
            for (int k = i; k < s.length(); k++) {
                if (chArr[k] != chArr[k - i]) {
                    System.out.println("NO");
                    isPerfectlyBalanced = false;
                    break;
                }
            }

            if (isPerfectlyBalanced) {
                System.out.println("YES");
            }
        }
    }
}
