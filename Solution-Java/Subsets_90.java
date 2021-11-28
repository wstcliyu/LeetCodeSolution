// Backtrack
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




// Cascading
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        int subsetSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int startingIndex = (i >= 1 && nums[i] == nums[i - 1]) ? subsetSize : 0;
            // subsetSize refers to the size of the subset in the previous step. This value also indicates the starting index of the subsets generated in this step.
            subsetSize = subsets.size();
            for (int j = startingIndex; j < subsetSize; j++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(nums[i]);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
}




// Bitmask
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        int n = nums.length;

        // Sort the generated subset. This will help to identify duplicates.
        Arrays.sort(nums);

        int maxNumberOfSubsets = (int) Math.pow(2, n);
        // To store the previously seen sets.
        Set<String> seen = new HashSet<>();

        for (int subsetIndex = 0; subsetIndex < maxNumberOfSubsets; subsetIndex++) {
            // Append subset corresponding to that bitmask.
            List<Integer> currentSubset = new ArrayList();
            StringBuilder hashcode = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // Generate the bitmask
                int mask = 1 << j;
                int isSet = mask & subsetIndex;
                if (isSet != 0) {
                    currentSubset.add(nums[j]);
                    // Generate the hashcode by creating a comma separated string of numbers in the currentSubset.
                    hashcode.append(nums[j]).append(",");
                }
            }
            if (!seen.contains(hashcode.toString())) {
                seen.add(hashcode.toString());
                subsets.add(currentSubset);
            }

        }

        return subsets;
    }
}