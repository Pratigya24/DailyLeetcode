// class Solution {
//     public List<Integer> targetIndices(int[] nums, int target) {
//         ArrayList<Integer> list = new ArrayList<>();
//         Arrays.sort(nums);

//         for(int i=0; i<nums.length; i++){
//             if(nums[i] == target){
//                 list.add(i);
//             }
//         }
//         return list;
//     }
// }

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num < target) {
                lessCount++;
            } else if (num == target) {
                count++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessCount + i);
        }

        return result;
    }
}