
import java.util.*;

public class DisctinctSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int arr[] = new int[26];
            HashSet<Character> setRight = new HashSet<>();
            for (int i = 0; i < n; i++) {
                arr[s.charAt(i) - 'a']++;
                setRight.add(s.charAt(i));
            }

            int ans = 0;
            HashSet<Character> setLeft = new HashSet<>();
            for (int i = 0; i < n; i++) {
                setLeft.add(s.charAt(i));
                --arr[s.charAt(i) - 'a'];
                if (arr[s.charAt(i) - 'a'] == 0) {
                    setRight.remove(s.charAt(i));
                }
                ans = Math.max(ans, setLeft.size() + setRight.size());
            }

            System.out.println(ans);
        }
    }
}
