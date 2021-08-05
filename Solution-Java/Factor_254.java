class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, 2);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int n, int start) {
        if (n == 1) {
            if (tmp.size() > 1) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                tmp.add(i);
                backtrack(res, tmp, n/i, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}