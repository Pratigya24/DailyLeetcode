class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        long sum = 0;

        for(int i=0;i<n; i++){
            sum += nums[i];
            min = Math.min(nums[i], min);
        }


        return (int) (sum - (long)(n*min));
    }
}