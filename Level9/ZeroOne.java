
import java.util.*;

public class ZeroOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            long zeroCount = 0;
            long oneCount = 0;
            for(int i=0;i<n;i++){
                if(s.charAt(i) == '0'){
                    zeroCount++;
                }else{
                    oneCount++;
                }
            }

            long moves = Math.min(zeroCount, oneCount);
            if (moves % 2 == 1) {
                System.out.println("DA");
            } else {
                System.out.println("NET");
            }
        }
    }
}
