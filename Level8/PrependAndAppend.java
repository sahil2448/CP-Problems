
import java.util.*;

public class PrependAndAppend {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();

            int i = 0, j = n - 1;

            while (i <= j) {
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(j);

                if ((ch1 == '1' && ch2 == '0') || (ch1 == '0' && ch2 == '1')) {
                    i++;
                    j--;
                    if (j < i) {
                        System.out.println(0);
                        break;
                    }
                } else {
                    if (i <= j) {
                        System.out.println(j - i + 1);
                    }
                    break;
                }
            }
        }
    }
}
