import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int result[] = new int[t];
        for (int x=0;x<t;x++){
            int n =sc.nextInt();
            int arr[] = new int[n];
            if (arr.length == 1){
                result[0] = 1;
            }
            for (int i = 0;i<n;i++){
                arr[i] = 0;

                int l = 0;
                int r = arr.length-1;
                int sum = (r-l+1)/2;

                for (int j = 0; j<sum ;j++){

                }
            }




        }
    }
}
