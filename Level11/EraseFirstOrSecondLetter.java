
import java.util.*;

public class EraseFirstOrSecondLetter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int arr[] = new int[26];
            long count = 0;
            long total = 0;

            for (int i = 0; i < n; i++) {
                if (arr[s.charAt(i) - 'a'] == 0) {
                    count++;
                }
                arr[s.charAt(i) - 'a']++;
                total += count;
            }

            System.out.println(total);
        }
    }
}
