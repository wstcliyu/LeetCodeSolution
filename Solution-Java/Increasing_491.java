class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new LinkedList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp, int start) {
        if (tmp.size() >= 2) {
            res.add(new ArrayList<>(tmp));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i]) || !tmp.isEmpty() && tmp.getLast() > nums[i]) {
                continue;
            }
            used.add(nums[i]);
            tmp.add(nums[i]);
            backtrack(nums, res, tmp, i + 1);
            tmp.removeLast();
        }
    }
}