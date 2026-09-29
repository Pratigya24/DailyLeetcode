// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         backtrack(nums, 0, result);
//         return result;
//     }

//     private void backtrack(int[] nums, int start, List<List<Integer>> result) {
//         if (start == nums.length) {
//             List<Integer> temp = new ArrayList<>();
//             for (int num : nums) temp.add(num);
//             result.add(temp);
//             return;
//         }

//         for (int i = start; i < nums.length; i++) {
//             swap(nums, start, i);
//             backtrack(nums, start + 1, result);
//             swap(nums, start, i);
//         }
//     }

//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> currentPerm = new LinkedHashSet<>();
        
        backtrack(nums, currentPerm, result);
        return result;
    }

    private void backtrack(int[] nums, Set<Integer> currentPerm, List<List<Integer>> result) {
        if (currentPerm.size() == nums.length) {
            result.add(new ArrayList<>(currentPerm));
            return;
        }

        for (int num : nums) {
            if (currentPerm.contains(num)) {
                continue;
            }
            currentPerm.add(num);
            backtrack(nums, currentPerm, result);
            currentPerm.remove(num);
        }
    }
}