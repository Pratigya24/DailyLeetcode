class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        
        // Calculate absolute differences and find max difference
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        
        // Store frequencies of each difference
        int[] count = new int[maxDiff + 1];
        for (int diff : diffs) {
            count[diff]++;
        }
        
        long k = (long) k1 + k2;
        
        // Reduce the largest differences first
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] == 0) continue;
            
            long take = Math.min(k, (long) count[d]);
            count[d] -= take;
            count[d - 1] += take;
            k -= take;
        }
        
        // Calculate the final sum of squared differences
        long result = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                result += (long) count[d] * d * d;
            }
        }
        
        return result;
    }
}