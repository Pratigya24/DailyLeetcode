class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums, 0, ans);
        return ans;
    }
    private void permutation(int[] nums, int level, List<List<Integer>> ans){
        if(nums.length == level){
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            if(!ans.contains(temp)){
                ans.add(temp);
            }
            return;
        }
        for(int i=level; i<nums.length; i++){
            swap(nums, level, i);
            permutation(nums, level+1, ans);
            swap(nums, level, i);
        }
    }

    private void swap(int[] nums, int level, int i){
        int temp = nums[level];
        nums[level] = nums[i];
        nums[i] = temp;
    }
}