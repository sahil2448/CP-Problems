import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long k = sc.nextLong();
            String s = sc.next();
            char[] arr = s.toCharArray();

            long count = 0;
            long currentStep = 0;
            long remainingK = k;

            // Initial phase simulation
            while (remainingK > 0 && currentStep < n) {
                char c = arr[(int) currentStep];
                long newX = x + (c == 'L' ? -1 : 1);
                if (newX == 0) {
                    count++;
                    currentStep = 0;
                } else {
                    currentStep++;
                }
                x = newX;
                remainingK--;
                if (remainingK == 0) break;
                if (currentStep == n) {
                    if (x == 0) {
                        count++;
                        currentStep = 0;
                        remainingK--;
                        x = 0;
                    } else {
                        break;
                    }
                }
            }

            if (remainingK == 0) {
                System.out.println(count);
                continue;
            }

            if (currentStep < n || x != 0) {
                System.out.println(count);
                continue;
            }

            long s1 = 0;
            long c1 = 0;
            boolean newAttempt = false;

            long tempX = 0;
            int firstZero = -1;
            for (int j = 0; j < n; j++) {
                char c = arr[j];
                tempX += (c == 'L' ? -1 : 1);
                if (tempX == 0) {
                    firstZero = j + 1;
                    break;
                }
            }

            if (firstZero != -1) {
                s1 = firstZero;
                c1 = 1;
                newAttempt = true;
            } else {
                if (tempX == 0) {
                    s1 = n;
                    c1 = 1;
                    newAttempt = true;
                } else {
                    s1 = n;
                    c1 = 0;
                    newAttempt = false;
                }
            }

            if (remainingK >= s1) {
                count += c1;
                remainingK -= s1;
                if (newAttempt) {
                    long fullCycles = remainingK / s1;
                    count += fullCycles * c1;
                    long remainingSteps = remainingK % s1;

                    tempX = 0;
                    long remCount = 0;
                    for (int j = 0; j < remainingSteps; j++) {
                        char c = arr[j];
                        tempX += (c == 'L' ? -1 : 1);
                        if (tempX == 0) {
                            remCount++;
                        }
                    }
                    count += remCount;
                }
            } else {
                tempX = 0;
                long remCount = 0;
                for (int j = 0; j < remainingK; j++) {
                    char c = arr[j];
                    tempX += (c == 'L' ? -1 : 1);
                    if (tempX == 0) {
                        remCount++;
                    }
                }
                count += remCount;
            }

            System.out.println(count);
        }
    }
}