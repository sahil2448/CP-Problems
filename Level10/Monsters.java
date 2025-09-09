
import java.util.*;

public class Monsters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            List<Pair> monsters = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int health = sc.nextInt();

                int remainder = health % k;

                if (remainder == 0) {
                    remainder = k;
                }

                monsters.add(new Pair(-remainder, i + 1)); // -remainder to sort in descending order
            }

            Collections.sort(monsters);

            for (Pair monster : monsters) {
                System.out.print(monster.index + " ");
            }
            System.out.println();
        }
    }

    static class Pair implements Comparable<Pair> {

        int remainder;
        int index;

        public Pair(int remainder, int index) {
            this.remainder = remainder;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) { // Fixed...can't be changed...
            if (this.remainder != other.remainder) {
                return Integer.compare(this.remainder, other.remainder); // increasing order sorting
            }
            return Integer.compare(this.index, other.index);
        }
    }
}


/*
 * JAVA SORTING CONCEPTS - QUICK REFERENCE
 * 
 * @Override Annotation:
 * - Indicates a method is overriding a method from a parent class/interface
 * - Helps catch errors if method signature doesn't match the parent's
 * - Not required but considered good practice for code clarity
 * 
 * Comparable Interface:
 * - Defines natural ordering for a class (its default sort order)
 * - Must be implemented by the class whose objects need to be sorted
 * - Contains a single method: compareTo(T o)
 * - Example: class MyClass implements Comparable { ... }
 * 
 * compareTo() Method:
 * - Must be implemented exactly as named when using Comparable
 * - Returns: negative if this  other
 * - Example implementation:
 *   public int compareTo(MyClass other) {
 *       return this.value - other.value; // Ascending order
 *   }
 * 
 * Collections.sort():
 * - Static method that sorts Lists using natural ordering or a Comparator
 * - Usage: Collections.sort(myList); // Uses compareTo
 * - Alternative: Collections.sort(myList, myComparator); // Uses custom comparator
 * 
 * Note: The compareTo method name cannot be changed as it's part of the
 * Comparable interface contract. All implementing classes must provide
 * this exact method.
 */
