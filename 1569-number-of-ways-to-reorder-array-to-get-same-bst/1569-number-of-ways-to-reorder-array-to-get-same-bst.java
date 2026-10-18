class Solution {
    private static final long MOD = 1_000_000_007L;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations (nCr) using Pascal's Triangle
        long[][] comb = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Subtract 1 at the end because we don't count the original arrangement
        return (int) ((dfs(list, comb) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums, long[][] comb) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Split elements into left and right subtrees
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = dfs(left, comb);
        long rightWays = dfs(right, comb);

        // Mix the left and right subtrees together keeping their relative order
        int totalLen = left.size() + right.size();
        long combineWays = comb[totalLen][left.size()];

        return (combineWays * leftWays % MOD) * rightWays % MOD;
    }
}