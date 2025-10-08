
import java.util.*;

public class BoxFitting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long w = sc.nextLong();

            TreeMap<Long, Integer> counts = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                long width = sc.nextLong();
                counts.put(width, counts.getOrDefault(width, 0) + 1);
            }

            int boxes = 0;
            int itemsPacked = 0;

            while (itemsPacked < n) {
                boxes++;
                long currentWidth = w;

                for (Long itemWidth : counts.keySet()) {
                    int numAvailable = counts.get(itemWidth);

                    while (numAvailable > 0 && currentWidth >= itemWidth) {
                        currentWidth -= itemWidth;
                        counts.put(itemWidth, counts.get(itemWidth) - 1);
                        numAvailable--;
                        itemsPacked++;
                    }
                }
            }

            System.out.println(boxes);
        }
    }
}
