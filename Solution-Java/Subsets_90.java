class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, res, new LinkedList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp, int start) {
        res.add(new LinkedList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            backtrack(nums, res, tmp, i + 1);
            tmp.removeLast();
        }
    }
}