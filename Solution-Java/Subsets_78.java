class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tmp, int start) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}