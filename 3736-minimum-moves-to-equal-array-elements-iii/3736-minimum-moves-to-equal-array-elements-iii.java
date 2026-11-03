class Solution {
    public int minMoves(int[] nums) {
        
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int diff =0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            diff = Math.abs(nums[i] - max);
            count += diff;
        }
        return count;
    }
}