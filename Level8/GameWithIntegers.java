import java.util.*;
public class GameWithIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String result[] = new String[t];

        for (int i=0;i<t;i++){
            int n = sc.nextInt();
            int count = 0;
            boolean x = true;

            while(true){
                if (count == 10){
                    result[i] = "Second";
                    break;
                }
                if (x == true){
                    if((n+1) % 3 == 0 || (n-1)%3 == 0){
                        result[i] = "First";
                        break;
                    }
                    n = n+1;
                } else{
                    if ((n+2) % 3 ==0){
                        n = n-1;
                    }
                    else if ((n-2) % 3 ==0) {
                        n = n + 1;
                    }
                }
                x = !x;
                count++;
            }

        }

        for (int i=0;i<t;i++){
            System.out.println(result[i]);
        }
    }
}
