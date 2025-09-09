import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] result = new int[t];
        sc.nextLine();

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            int count = 0;
            if (!str.contains("1")) {
                result[k] = 0;
            } else if (!str.contains("0")) {
                result[k] = 1;
            } else {
                while (str.contains("1")) {
                    int firstOne = str.indexOf('1');
                    if (firstOne != -1) {
                        str = str.substring(firstOne + 1);
                        count++;
                    } else {
                        break;
                    }

                    if (str.contains("0")) {
                        int firstZero = str.indexOf('0');
                        if(firstZero != -1) {
                            str = str.substring(firstZero + 1);
                            count++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                result[k] = count;
            }
        }

        for (int val : result) {
            System.out.println(val);
        }
        sc.close();
    }
}