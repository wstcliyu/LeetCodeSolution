class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] nums, boolean[] used, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                } else {
                    used[i] = true;
                    tmp.add(nums[i]);
                    backtrack(nums, used, tmp, res);
                    used[i] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}