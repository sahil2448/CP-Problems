
import java.util.*;

public class BlankSpaces {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            int maxLen = 0;
            int i=0;
            int counter = 0;
            while(i<n){
                if(arr[i] == 0){
                    counter++;
                    maxLen = Math.max(counter, maxLen);
                }
                else if(arr[i] == 1){
                    counter = 0;
                }  
                i++;
            }
            System.out.println(maxLen);
        }
    }
}
