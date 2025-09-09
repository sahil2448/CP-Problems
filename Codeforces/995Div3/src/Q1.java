import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int result[] = new int[t];

        for (int j=0;j<t;j++){
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[]  = new int[n];

            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            for (int i=0;i<n;i++){
                b[i] = sc.nextInt();
            }
            int p1 = 0;
            int p2 = 0;



            for (int i=0;i<n;i++){

                if(i==n-1){
                    p1+= a[i];
                    result[j] = Math.abs(p1-p2);
                    break;
                }

                if (a[i]>b[i+1] && i<n-1){
                    p1 += a[i];
                    p2 += b[i+1];
                }

                else if(b[i+1]>a[i] && i<n-1){
                    continue;
                }


            }
        }

        for (int i=0;i<t;i++){
            System.out.println(result[i]);
        }
    }
}
