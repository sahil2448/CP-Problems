
import java.util.*;

public class DaytonaCost {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean flag = false;
            int arr[] = new int [n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i=0;i<arr.length;i++){
                if(arr[i] == k){
                    flag = true;
                    System.out.println("YES");
                    break;
                }
            }
            if (flag == false) {
                System.out.println("NO");
            }
        }

    }
}
