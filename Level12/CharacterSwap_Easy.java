
import java.util.*;

public class CharacterSwap_Easy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int size = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();

            ArrayList<Character> list1 = new ArrayList<>();
            ArrayList<Character> list2 = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    list1.add(s1.charAt(i));
                    list2.add(s2.charAt(i));
                    count++;
                }
            }

            if (count == 2) {
                if (list1.get(0) == list1.get(1) && list2.get(0) == list2.get(1)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
