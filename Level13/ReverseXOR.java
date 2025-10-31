
import java.util.*;

public class ReverseXOR {

    public static boolean isPalindrome(String s) {
        char charArray[] = s.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < n / 2; i++) {
            if (charArray[i] != charArray[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = Integer.toBinaryString(n);

            if (isPalindrome(s)) {
                System.out.println("YES");
                continue;
            }

            boolean flag = false;
            for (int i = 0; i < 30; i++) {
                s = "0" + s;
                if (isPalindrome(s)) {
                    if (s.length() % 2 != 0 && s.charAt(s.length() / 2) == '0') {
                        System.out.println("YES");
                        flag = true;
                        break;
                    } else if (s.length() % 2 == 0) {
                        System.out.println("YES");
                        flag = true;
                        break;
                    }

                }
            }

            if (!flag) {
                System.out.println("NO");
            }
        }
    }

}
