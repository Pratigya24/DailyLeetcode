class Solution {
    public int maxAscendingSum(int[] nums) {
        int n= nums.length;
        int max = nums[0];
        int maxSum = max;

        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]){
                max += nums[i];
            }
            else{
                max = nums[i];
            }

            maxSum = Math.max(max, maxSum);
        }
        return maxSum;
    }
}