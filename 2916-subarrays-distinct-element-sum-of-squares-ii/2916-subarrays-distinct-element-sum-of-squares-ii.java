import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    class SegmentTree {
        long[] sum;
        long[] sumSq;
        long[] lazy;

        SegmentTree(int n) {
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void push(int node, int start, int end) {
            if (lazy[node] != 0) {
                long val = lazy[node];
                int mid = (start + end) / 2;

                apply(2 * node, start, mid, val);
                apply(2 * node + 1, mid + 1, end, val);

                lazy[node] = 0;
            }
        }

        private void apply(int node, int start, int end, long val) {
            long len = end - start + 1;
            sumSq[node] = (sumSq[node] + 2 * val % MOD * sum[node] % MOD + len * val % MOD * val % MOD) % MOD;
            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        public void update(int node, int start, int end, int l, int r, long val) {
            if (l <= start && end <= r) {
                apply(node, start, end, val);
                return;
            }

            push(node, start, end);
            int mid = (start + end) / 2;

            if (l <= mid) update(2 * node, start, mid, l, r, val);
            if (r > mid) update(2 * node + 1, mid + 1, end, l, r, val);

            sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
            sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
        }

        public long querySumSq() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int prevIdx = lastSeen.getOrDefault(nums[i], -1);
            
            // Increment distinct count for all subarrays starting from (prevIdx + 1) to i
            tree.update(1, 0, n - 1, prevIdx + 1, i, 1);
            
            // Add current sum of squares to total answer
            totalSum = (totalSum + tree.querySumSq()) % MOD;

            lastSeen.put(nums[i], i);
        }

        return (int) totalSum;
    }
}