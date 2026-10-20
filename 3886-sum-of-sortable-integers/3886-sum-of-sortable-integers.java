class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Check every divisor k of n
        for (int k = 1; k <= n; k++) {
            if (n % k == 0) {
                if (isSortable(nums, n, k)) {
                    sum += k;
                }
            }
        }

        return sum;
    }

    private boolean isSortable(int[] nums, int n, int k) {
        int prevMax = Integer.MIN_VALUE;

        // Process each block of size k
        for (int i = 0; i < n; i += k) {
            int drops = 0;
            int dropIdx = -1;

            // Count circular drops in the current subarray
            for (int j = 0; j < k; j++) {
                int curr = nums[i + j];
                int next = nums[i + (j + 1) % k];

                if (curr > next) {
                    drops++;
                    dropIdx = j;
                }
            }

            // More than 1 drop means this subarray cannot be cyclically rotated into sorted order
            if (drops > 1) {
                return false;
            }

            int minVal, maxVal;
            if (drops == 0) {
                // All elements in the block are equal
                minVal = nums[i];
                maxVal = nums[i];
            } else {
                // The drop index gives us the boundary between max and min
                minVal = nums[i + (dropIdx + 1) % k];
                maxVal = nums[i + dropIdx];
            }

            // Ensure the entire array remains non-decreasing across blocks
            if (minVal < prevMax) {
                return false;
            }

            prevMax = maxVal;
        }

        return true;
    }
}