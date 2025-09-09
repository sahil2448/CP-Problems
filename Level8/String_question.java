
import java.util.*;

public class String_question {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                }
            }
            System.out.println(oneCount);
        }
    }
}
