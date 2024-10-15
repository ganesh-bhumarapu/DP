import java.util.*;
public class NumberOfUniquePaths {
    public static int noOfPaths(int a, int b){
        int[][] dp = new int[a][b];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(i == 0 && j == 0) dp[i][j] = 1;

                else{
                    int down = 0;
                    int right = 0;
                    if(i > 0){
                        down = dp[i - 1][j];
                    }
                    if(j > 0){
                        right = dp[i][j - 1];
                    }
                    dp[i][j] = down + right;
                }
            }
        }
        return dp[a - 1][b - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(noOfPaths(a, b));
    }
}
