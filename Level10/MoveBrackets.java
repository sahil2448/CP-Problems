
import java.util.*;

public class MoveBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            String s = sc.next();
            Stack<Character> A = new Stack<>();
            Stack<Character> B = new Stack<>();
            long counter = 0;

            for (long i = 0; i < n; i++) {
                char ch = s.charAt((int) i);
                if (ch == '(' && B.size() != 0) {
                    B.pop();
                } else if (ch == '(') {
                    A.push(ch);
                } else if (ch == ')' && A.size() != 0) {
                    A.pop();

                } else if (ch == ')') {
                    B.push(ch);
                    counter++;
                }
            }

            System.out.println(counter);

        }
    }
}
