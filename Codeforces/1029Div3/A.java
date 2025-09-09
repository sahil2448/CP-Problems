
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int i = 0;
            boolean canPass = false;
            boolean flag = false;
            while (i < n) {
                if (arr[i] == 0) {
                    i++;
                } else {
                    if (!canPass) {
                        i += x;
                        canPass = true;
                    } else {
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false) {
                System.out.println("YES");
            }
        }

    }
}
