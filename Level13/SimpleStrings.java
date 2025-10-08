
import java.util.*;

public class SimpleStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char alfabetes[] = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        String s = sc.next();
        char a[] = s.toCharArray();

        if (a.length == 1) {
            a[0] = s.charAt(0);
        } else if (a.length == 2) {
            if (a[0] == a[1]) {
                a[1] = alfabetes['z' - a[0]];
                if (a[1] == a[0]) { // fallback if mirrored equals prev (paranoia)
                    for (int k = 0; k < 26; k++) {
                        if (alfabetes[k] != a[0]) {
                            a[1] = alfabetes[k];
                            break;
                        }
                    }
                }
            }
        } else {
            for (int i = 1; i < a.length; i++) {
                if (a[i] == a[i - 1]) {
                    int idx = 'z' - a[i];
                    char cand = alfabetes[idx];
                    if (cand != a[i - 1] && (i == a.length - 1 || cand != a[i + 1])) {
                        a[i] = cand;
                    } else {
                        for (int k = 0; k < 26; k++) {
                            char c = alfabetes[k];
                            if (c != a[i - 1] && (i == a.length - 1 || c != a[i + 1])) {
                                a[i] = c;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(new String(a));
    }
}
