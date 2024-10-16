import java.util.*;
public class GridPathII {
    public static int uniquePaths(int[][] grid, int N, int M){
        final  int MOD = 100000007;
        if(grid[0][0] == 1 || grid[N - 1][M - 1] == 1) return 0;

        int[][] dp = new int[N][M];
        dp[0][0] = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                }else{
                    if(i > 0){
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if(j > 0){
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }
        }
        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grid = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(uniquePaths(grid, N, M));
    }
}
