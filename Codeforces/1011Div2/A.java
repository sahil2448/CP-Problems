import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine(); 
            String s = sc.nextLine();
            
            if (n == 1 || allSame(s)) {
                System.out.println("NO");
                continue;
            }
            
            if (k == 0) {
                String rev = new StringBuilder(s).reverse().toString();
                if (s.compareTo(rev) < 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("YES");
            }
        }
    }
    
    private static boolean allSame(String s) {
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != first) {
                return false;
            }
        }
        return true;
    }
}
