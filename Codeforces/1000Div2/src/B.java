import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            // Get segment elements
            ArrayList<Integer> segment = new ArrayList<>();
            for (int i = l - 1; i < r; i++) {
                segment.add(arr.get(i));
            }

            // Get elements outside segment
            ArrayList<Integer> outside = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i < l - 1 || i >= r) {
                    outside.add(arr.get(i));
                }
            }

            Collections.sort(segment, Collections.reverseOrder());
            Collections.sort(outside);

            long sum = 0;
            int outsideIndex = 0;

            // Replace larger elements in segment with smaller elements from outside
            for (int i = 0; i < segment.size(); i++) {
                if (outsideIndex < outside.size() && segment.get(i) > outside.get(outsideIndex)) {
                    sum += outside.get(outsideIndex++);
                } else {
                    sum += segment.get(i);
                }
            }

            System.out.println(sum);
        }
    }
}