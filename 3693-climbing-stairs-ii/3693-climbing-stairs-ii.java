class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0, b = 0, c = 0;  // dp[i - 1], dp[i - 2], dp[i - 3] for i = 1, the fake steps below 0 never win
        for (int cost : costs) {
            int cur = cost + Math.min(a + 1, Math.min(b + 4, c + 9));  // dp[i]
            c = b;
            b = a;
            a = cur;
        }
        return a;
    }
}