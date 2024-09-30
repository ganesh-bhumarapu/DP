import java.util.*;
public class SticklerThief{
    // tabularForm -> TC -> O(n) & SC -> O(1)
//    public static int FindMaxSum(int[] arr, int n) {
//        int[] dp = new int[n];
//        dp[0] = arr[0];
//        for (int i = 1; i < n; i++) {
//            int pick = arr[i];
//            if (i > 1) {
//                pick = arr[i] + dp[i - 2];
//            }
//            int nonPick = dp[i - 1];
//
//            dp[i] = Math.max(pick, nonPick);
//        }
//        return dp[n - 1];
//    }
    // TC -> O(N) SC -> O(1)
    public static int FindMaxSum(int[] arr, int n) {
        int prev1 = arr[0];
        int prev2 = 0;
        for(int i = 1; i < n; i++){
            int pick = arr[i];
            if(i > 1){
                pick = arr[i] + prev2;
            }
            int nonPick = prev1;

            int curri = Math.max(pick, nonPick);

            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(FindMaxSum(arr, n));
    }
}
