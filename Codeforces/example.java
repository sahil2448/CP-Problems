import java.util.*;
public class example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String arr[] = new String[t];
        for(int i=0;i<t;i++){
            int n = sc.nextInt();

            if(n%100==0){
                arr[i] = "NO";
            }
            else{
                String intStr = String.valueOf(n);
                if(intStr.length() >3 && Character.getNumericValue(intStr.charAt(0))==1 && Character.getNumericValue(intStr.charAt(1))==0 &&  Character.getNumericValue(intStr.charAt(1))>=2){
                    arr[i] = "YES";
                }
                else{
                    arr[i] ="NO";
                }
            }
        }

        for(int i=0;i<t;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
