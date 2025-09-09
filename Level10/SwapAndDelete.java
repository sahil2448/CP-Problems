
import java.util.*;

public class SwapAndDelete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            long zeroCount = 0;
            long oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            if (oneCount == zeroCount || s.length() == 0) {
                System.out.println(0);
            } else if (oneCount == 0 || zeroCount == 0) {
                System.out.println(s.length());
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '1') {
                        zeroCount--;
                        if (zeroCount < 0) {
                            System.out.println(s.length() - (i));
                            break;
                        }
                    } else {
                        oneCount--;
                        if (oneCount < 0) {
                            System.out.println(s.length() - (i));
                            break;
                        }
                    }
                }
            }
        }
    }
}
