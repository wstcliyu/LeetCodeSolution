class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new LinkedList<>(), 1, k, n);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, LinkedList<Integer> tmp, int start, int k, int n) {
        if (k == 0) {
            if (n == 0) {
                res.add(new LinkedList<>(tmp));
            }
        } else {
            for (int i = start; i <= Math.min(9, n); i++) {
                tmp.add(i);
                backtrack(res, tmp, i + 1, k - 1, n - i);
                tmp.removeLast();
            }
        }
    }
}