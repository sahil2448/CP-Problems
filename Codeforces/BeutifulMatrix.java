import java.util.Scanner;

public class BeutifulMatrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int matrixSize = 5;
        int oneRow = -1, oneCol = -1;
        
        // Read the matrix and find the position of '1'
        for (int i = 1; i <= matrixSize; i++) {
            for (int j = 1; j < matrixSize; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    oneRow = i;
                    oneCol = j;
                }
            }
        }
        // The target position (center of the matrix) is (3,3)
        int targetRow = 3;
        int targetCol = 3;
        
        // Calculate the number of moves needed
        int moves = Math.abs(oneRow - targetRow) + Math.abs(oneCol - targetCol);
        
        // Print the result
        System.out.println(moves);
        
        scanner.close();
    }
}
