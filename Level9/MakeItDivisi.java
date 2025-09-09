import java.util.Scanner;

public class MakeItDivisi {

    public static long func(String n,String s){
        long operations = 0;
        char charArr[] = n.toCharArray();
        int checkerIdx = s.length()-1;

        for(long i=charArr.length-1;i>=0;i--){
            if(s.charAt(checkerIdx) == charArr[(int)i]){
                checkerIdx--;
                if(checkerIdx < 0){
                    break;
                }
            } else{
                operations++;
            }
        }

        if(checkerIdx>=0){
            return Long.MAX_VALUE;
        }

        return operations;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            String n = sc.next();

            String arr[] = {"00","25","50","75"};

            long ops = Long.MAX_VALUE;
            for(String s : arr){
                ops = Math.min(func(n,s),ops);
            }

            System.out.println(ops);
        }

    }
}