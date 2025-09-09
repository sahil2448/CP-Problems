
import java.util.*;

public class HelpfulMaths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int count1 = 0, count2 = 0, count3 = 0;

        for (int i = 0; i < s.length(); i += 2) {
            char digit = s.charAt(i);
            if (digit == '1') {
                count1++;
            } else if (digit == '2') {
                count2++;
            } else if (digit == '3') {
                count3++;
            }
        }

        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < count1; i++) {
            if (!first) {
                result.append("+");
            }
            result.append("1");
            first = false;
        }

        for (int i = 0; i < count2; i++) {
            if (!first) {
                result.append("+");
            }
            result.append("2");
            first = false;
        }

        for (int i = 0; i < count3; i++) {
            if (!first) {
                result.append("+");
            }
            result.append("3");
            first = false;
        }

        System.out.println(result.toString());
    }
}
