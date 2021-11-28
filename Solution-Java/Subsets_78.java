// Backtrack
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new LinkedList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp, int start) {
        res.add(new LinkedList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, res, tmp, i + 1);
            tmp.removeLast();
        }
    }
}




// Cascading
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();
    output.add(new ArrayList<Integer>());

    for (int num : nums) {
      List<List<Integer>> newSubsets = new ArrayList();
      for (List<Integer> curr : output) {
        newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
      }
      for (List<Integer> curr : newSubsets) {
        output.add(curr);
      }
    }
    return output;
  }
}




// Bitmask
class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();
    int n = nums.length;

    for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // append subset corresponding to that bitmask
      List<Integer> curr = new ArrayList();
      for (int j = 0; j < n; ++j) {
        if (bitmask.charAt(j) == '1') curr.add(nums[j]);
      }
      output.add(curr);
    }
    return output;
  }
}