class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[30];
        
        // Count how many times each bit appears across all numbers
        for (int num : nums) {
            for (int b = 0; b < 30; b++) {
                if (((num >> b) & 1) == 1) {
                    bitCount[b]++;
                }
            }
        }
        
        long ans = 0;
        long MOD = 1_000_000_007;
        
        // Construct the k largest possible numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int b = 0; b < 30; b++) {
                if (bitCount[b] > 0) {
                    currentNum |= (1L << b);
                    bitCount[b]--; // Use up one 1 for this bit position
                }
            }
            ans = (ans + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) ans;
    }
}