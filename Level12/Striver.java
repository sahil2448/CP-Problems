
import java.util.*;

public class Striver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();

        String numString = Long.toString(x);
        char charArr[] = numString.toCharArray();

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < charArr.length; i++) {
            char ch = charArr[i];
            int num = ch - '0';

            if (num > 4 && !(i == 0 && num == 9)) {
                num = 9 - num;
            }
            sb.append(num);
        }

        String res = sb.toString();
        long ans = Long.parseLong(res);
        System.out.println(ans);
    }
}
