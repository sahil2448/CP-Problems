
import java.util.*;

public class PrinzessinDerVerurteilung {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            String ans = "";

            for (int i = 0; i < 26; i++) {
                char ch = (char) ('a' + i);
                String temp = "" + ch;
                if (!s.contains(temp)) {
                    ans = temp;
                    break;
                }
            }

            if (ans.equals("")) {
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < 26; j++) {
                        String temp = "" + (char) ('a' + i) + (char) ('a' + j);
                        if (!s.contains(temp)) {
                            ans = temp;
                            break;
                        }
                    }
                    if (!ans.equals("")) {
                        break;
                    }
                }
            }

            if (ans.equals("")) {
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < 26; j++) {
                        for (int k = 0; k < 26; k++) {
                            String temp = "" + (char) ('a' + i) + (char) ('a' + j) + (char) ('a' + k);
                            if (!s.contains(temp)) {
                                ans = temp;
                                break;
                            }
                        }
                        if (!ans.equals("")) {
                            break;
                        }
                    }
                    if (!ans.equals("")) {
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
