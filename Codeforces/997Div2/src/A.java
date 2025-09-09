import java.util.*;
public class A {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();


        for (int i=0;i<t;i++){
            ArrayList<ArrayList<Integer>> input = new ArrayList<>();

            int n = sc.nextInt();
            int m = sc.nextInt();

            int tPeri = m*4*n;

            for (int j=0;j<n;j++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                ArrayList<Integer> l = new ArrayList<>();
                l.add(x);
                l.add(y);

                input.add(l);
            }

            int x1 = input.get(0).get(0);
            int y1 = input.get(0).get(1);

            for(int j=1;j<input.size();j++){
                int x = input.get(j).get(0);
                int y = input.get(j).get(1);

                int distX = m - (x+x1 - x1);
                int distY = m - (y+y1 - y1);
                x1 = x;

                y1 = y;

                tPeri = tPeri- 2*distY - 2*distX;
            }

            System.out.println(tPeri);

        }
    }
}
