import java.util.*;
public class Chemistry{
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String str = sc.next();
            int arr[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)-'a']++;
            }
            int count = 0;

            for(int i=0;i<arr.length;i++){
                if(arr[i]%2 != 0){
                    count++;
                }
            }

            if(count > k+1){
                System.out.println("NO");
            } else{
                System.out.println("YES");
            }
        }
    }
}