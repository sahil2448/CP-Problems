import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String result[] = new String[t];
        for(int i=0;i<t;i++){
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for(int j=s.length()-1;j>=0;j--){
                char ch = s.charAt(j);
                if(ch == 'p'){
                    sb.append('q');
                } else if(ch =='q'){
                    sb.append('p');
                } else if(ch == 'w'){
                    sb.append('w');
                }
                result[i] = sb.toString();
            }

        }

        for (int i=0;i<t;i++){
            System.out.println(result[i]);
        }

    }
}
