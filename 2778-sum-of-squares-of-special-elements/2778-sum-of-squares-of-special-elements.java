class Solution {
    public int sumOfSquares(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int mul = Integer.MIN_VALUE;
        for(int i =0; i < n ; i++){
            if(n % (i+1) ==0){
                mul = nums[i]*nums[i];
                sum += mul;
            }
        }
        return sum;
    }
}