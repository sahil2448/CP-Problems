
import java.util.*;

public class OlyaAndGameWithTheArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long secondElements[] = new long[(int) n];
            long lowestFirstMin = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                long m = sc.nextLong();
                long arr[] = new long[(int) m];
                for (int j = 0; j < m; j++) {
                    arr[j] = sc.nextLong();
                }
                Arrays.sort(arr);
                secondElements[i] = arr[1];
                lowestFirstMin = Math.min(lowestFirstMin, arr[0]);
            }
            Arrays.sort(secondElements);
            long lowestSecondEle = secondElements[0];
            long sum = 0;
            for (long num : secondElements) {
                sum += num;
            }

            System.out.println(sum - lowestSecondEle + lowestFirstMin);
        }
    }
}
