// Negative Marking
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for (int v : nums) {
            v = Math.abs(v);
            if (nums[v - 1] < 0) {
                res.add(v);
            } else {
                nums[v - 1] *= -1;
            }
        }
        
        return res;
    }
}