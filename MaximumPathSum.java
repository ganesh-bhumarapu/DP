import java.util.*;
public class MaximumPathSum {
    static  int maximumPath(int N, int Matrix[][])
    {
        // code here
        int[][] dp = new int[N][N];

        for(int i = 0; i < N; i++){
            dp[N - 1][i] = Matrix[N - 1][i];
        }
        for(int i = N - 2; i >= 0; i--){
            for(int j = 0; j < N; j++){
                int down = 0, dLeft = 0, dRight = 0;
                down = Matrix[i][j] + dp[i + 1][j];
                if(j > 0) dLeft = Matrix[i][j] + dp[i + 1][j - 1];
                if(j < N - 1) dRight = Matrix[i][j] + dp[i + 1][j + 1];

                dp[i][j] = Math.max(down, Math.max(dLeft, dRight));
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, dp[0][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] Matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(maximumPath(N, Matrix));
    }
}
