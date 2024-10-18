import java.util.*;
public class TrianglePathSum {
    public static int minimumPath(int n, ArrayList<ArrayList<Integer>> grid){
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++){
            dp[n - 1][j] = grid.get(n - 1).get(j);
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = grid.get(i).get(j) + dp[i + 1][j];
                int diag = grid.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(sc.nextInt());
            }
            grid.add(row);
        }
        System.out.println(minimumPath(n, grid));
    }
}