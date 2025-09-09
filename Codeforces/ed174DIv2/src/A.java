import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int arr[] = new int[n-2];
            for (int i=0;i<n-2;i++){
                arr[i] = sc.nextInt();
            }

            int left = 0;
            int mid = left+1;
            int right = left+2;
            boolean flag = true;
            while(right<n-2){
                if(arr[left] == 1 && arr[mid] ==0 && arr[right] == 1){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
                left++;
                right++;
                mid++;
            }
            if(flag == true){
                System.out.println("YES");
            }

            t--;
        }
    }
}
