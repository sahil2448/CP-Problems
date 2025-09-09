import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t>0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int freq[] = new int[10];
            boolean vis[] = new boolean[10];
            int matrix[][] = new int[m][n];
            int  maxFreq= 0;
            int don = 0;

            HashMap<Integer,ArrayList<Integer>> noNbr = new HashMap<>();
            HashMap<Integer,ArrayList<Integer>> nbr = new HashMap<>();

            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    matrix[i][j] = sc.nextInt();
                    freq[matrix[i][j]]++;
                    if (freq[matrix[i][j]] > maxFreq){
                        don = matrix[i][j];
                    }
                }
            }

            int dirs[][] = {{1,0},{0,1},{0,-1},{-1,0}};
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    int num = matrix[i][j];
                    for (int dir[]:dirs){
                        int nRow = i + dir[0];
                        int nCol = j + dir[1];
                        if (nRow > 0 && nCol > 0 && nRow < m && nCol<n){
                            if (num == matrix[nRow][nCol]){
                                ArrayList<Integer> a = nbr.get(num);
                                a.add(num);
                                a.add(num);
                                nbr.put(num,a);
                            } else{
                                ArrayList<Integer> b = noNbr.get(num);
                                b.add(num);
                            }
                        }
                    }
                }
            }

            t--;
        }
    }
}
