import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int result[] = new int[t];

        for (int k = 0; k < t; k++) {
            String str = sc.nextLine();
            int count = str.length();
            if(count == 1){
                result[k] = count;
            } else if(count == 2){
                if(str.charAt(0) == str.charAt(1)){
                    result[k] = 1;
                } else{
                    result[k] = 2;
                }
            }
            else{
                char arr[] = str.toCharArray();
                for(int i=arr.length-2;i>=0;i--){
                    char ch = arr[i];
                    if(ch == arr[i+1] && (i-1>=0)){
                        arr[i] = arr[i-1];
                        count--;
                    }
                    if(i == 0 && ch == arr[i+1]){
                        count--;
                    }

                }
                result[k] = count;
            }
        }

        for (int i=0;i<t;i++){
            System.out.println(result[i]);
        }

    }
}