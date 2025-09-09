
import java.util.*;

public class GrandmaCapaKnitsAScarf {

    public static boolean checkPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
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
            String s = sc.next();

            char[] chars = s.toCharArray();

            if (checkPalindrome(s)) {
                System.out.println(0);
                continue;
            }

            int left = 0;
            int right = n - 1;

            while (left < right && chars[left] == chars[right]) {
                left++;
                right--;
            }

            char leftChar = chars[left];
            char rightChar = chars[right];
            int countLeft = 0;
            int countRight = 0;

            boolean flag1 = true;
            while (left < right) {
                if (chars[left] == chars[right]) {
                    right--;
                    left++;
                } else {
                    if (chars[left] == leftChar) {
                        countLeft++;
                        left++;
                    } else if (chars[right] == leftChar) {
                        countLeft++;
                        right--;
                    } else if (chars[left] != leftChar && chars[right] != leftChar) {
                        flag1 = false;
                        break;
                    }
                }
            }

            left = 0;
            right = n - 1;

            while (left < right && chars[left] == chars[right]) {
                left++;
                right--;
            }
            boolean flag2 = true;
            while (left < right) {
                if (chars[left] == chars[right]) {
                    right--;
                    left++;
                } else {
                    if (chars[left] == rightChar) {
                        countRight++;
                        left++;
                    } else if (chars[right] == rightChar) {
                        countRight++;
                        right--;
                    } else if (chars[left] != rightChar && chars[right] != rightChar) {
                        flag2 = false;
                        break;
                    }
                }
            }

            if (!flag1 && !flag2) {
                System.out.println(-1);
                continue;
            }

            if (flag1 && flag2) {
                System.out.println(Math.min(countLeft, countRight));
            } else if (flag1) {
                System.out.println(countLeft);
            } else if (flag2) {
                System.out.println(countRight);
            }
        }
    }
}
