
import java.util.*;

public class DivisibilityOfDifferences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int remainder = num % m;

            if (!groups.containsKey(remainder)) {
                groups.put(remainder, new ArrayList<Integer>());
            }

            groups.get(remainder).add(num);
        }

        for (List<Integer> group : groups.values()) {
            if (group.size() >= k) {
                System.out.println("Yes");
                for (int i = 0; i < k; i++) {
                    System.out.print(group.get(i));
                    if (i < k - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
                return;
            }
        }

        System.out.println("No");
    }
}

// ## Step-by-Step Explanation
// **1. Reading Input:**  
// We start by reading three integers:  
// - **n**: the total number of elements  
// - **k**: the minimum number of elements we need in a group  
// - **m**: the modulo value used to group elements
// **2. Creating the Groups Map:**  
// We use a `HashMap` where:  
// - **Key**: the remainder when a number is divided by `m`  
// - **Value**: a list of numbers that have the same remainder
// **3. Grouping Numbers by Remainder:**  
// For each number read from input:  
// - **Calculate the remainder** by taking the number modulo `m`  
// - **Check if a group already exists** for that remainder  
//   - If not, **create a new ArrayList** and put it in the map  
//   - If yes, **get the existing ArrayList**  
// - **Add the number** to the appropriate group (list)
// **4. Checking for Valid Groups:**  
// After grouping all numbers:  
// - **Iterate through all groups** in the map  
// - **Check if any group has at least k elements**  
//   - If such a group is found, **print "YES"**  
//   - **Print the first k numbers** from that group  
//   - **Exit the program** (since we have found the answer)
// **5. No Valid Group Found:**  
// If **no group** with at least k elements is found, **print "NO"**
// **6. Resource Cleanup:**  
// Finally, **close the scanner** to release resources
// ---
// You can paste this explanation alongside or above your code for clarity!
// ---
// Answer from Perplexity: pplx.ai/share
