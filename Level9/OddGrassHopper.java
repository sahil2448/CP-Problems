
import java.util.*;

class OddGrassHopper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long start = sc.nextLong();
            long jumps = sc.nextLong();
            long final_pos = 0;

            if (jumps % 4 == 1) {
                final_pos = -jumps;
            } else if (jumps % 4 == 2) {
                final_pos = 1;
            } else if (jumps % 4 == 3) {
                final_pos = jumps + 1;
            } else if (jumps % 4 == 0) {
                final_pos = 0;
            }

            if (start % 2 == 0) {
                final_pos = start + final_pos;
            } else {
                final_pos = start - final_pos;
            }
            System.out.println(final_pos);
        }

    }
}
