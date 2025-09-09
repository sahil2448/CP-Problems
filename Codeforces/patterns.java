// import java.util.*;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         for(int i=0;i<n;i++){
//             for(int j=0;j<=i;j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }
/**
 * patterns
 */

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();

//         for(int i=n;i>0;i--){
//             for(int j=i;j>0;j--){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }





import java.util.*;

public class patterns {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int newI = 0;
        int newJ = 0;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                while((arr[i+1][j]>arr[i][j] && arr[i][j+1]>arr[i][j]) ||  (arr[i-1][j]>arr[i][j]&&  arr[i][j-1]>arr[i][j]))
                // mx = arr[i][j];
                    arr[i][j]-=1;
            }
        }

        for(int i=0;i<n;i++){ 
            for(int j=0;j<m;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}
