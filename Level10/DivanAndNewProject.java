
import java.util.*;

public class DivanAndNewProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            ArrayList<Integer> arrayOfList[] = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                arrayOfList[i] = new ArrayList<>();
                arrayOfList[i].add(i);  // Original index
                arrayOfList[i].add(arr[i]);    // Frequency value
            }

            // Sort by frequency in descending order
            Arrays.sort(arrayOfList, (a, b) -> Long.compare(b.get(1), a.get(1)));

            int result[] = new int[n + 1];
            result[0] = 0;

            int minutes = 0;
            int coordinate = 1;

            for (int i = 0; i < n; i++) {
                int originalIndex = arrayOfList[i].get(0);
                int frequency = arrayOfList[i].get(1);

                result[(int) originalIndex + 1] = coordinate;
                minutes += 2 * Math.abs(coordinate) * frequency;

                if (coordinate > 0) {
                    coordinate = -coordinate;
                } else {
                    coordinate = -coordinate + 1;
                }
            }

            System.out.println(minutes);
            for (int i = 0; i <= n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
