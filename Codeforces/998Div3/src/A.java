import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int res[] = new int[t];

        for (int i=0;i<t;i++){
            int arr[] = new int[5];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[3] = sc.nextInt();
            arr[4] = sc.nextInt();

            arr[2] = arr[3] - arr[1];
            int count = 0;
            for (int j=2;j<arr.length;j++){
                if (arr[j] == arr[j-1]+arr[j-2]){
                    count++;
                }
            }

            res[i] = count;
        }

        for (int i=0;i<t;i++){
            System.out.println(res[i]);
        }

    }
}
