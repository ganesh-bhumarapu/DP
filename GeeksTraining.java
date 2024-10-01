import java.util.*;

public class GeeksTraining {
    public static int maximumPoints(int[][] arr, int N){
        int[][] dp = new int[N][3];
        //base case when day = 0
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int day = 1; day < N; day++){
            dp[day][0] = arr[day][0] + Math.max(dp[day - 1][1], dp[day - 1][2]);

            dp[day][1] = arr[day][1] + Math.max(dp[day - 1][0], dp[day - 1][2]);

            dp[day][2] = arr[day][2] + Math.max(dp[day - 1][0], dp[day - 1][1]);
        }
        return Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i  < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(maximumPoints(arr, N));
    }
}
