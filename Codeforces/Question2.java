import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ans[] = new int[t];

        for (int i=0;i<t;i++){
            int k = sc.nextInt();
            int count = 0;
            while(count != k){
                int bulbs = k;
                int arr[] = new int[bulbs];
                Arrays.fill(arr,1);
                for (int j=1;j<arr.length;j++){
                    if(j==1){
                        Arrays.fill(arr,1);
                    }

                }

            }


        }
    }
}
