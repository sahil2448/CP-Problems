import java.util.*;
public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k=0;k<t;k++){
            int l = sc.nextInt();
            int r = sc.nextInt();

            int count = 0;

            if(l == 1 && r==1){
                count = 1;
            }

            else if(l == 1){
                count = Math.abs(r-1);
            } else if(r>2){
                count = Math.abs(l-r);
            }

            System.out.println(count);
        }
    }
}
