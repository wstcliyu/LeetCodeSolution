class Solution {
    // Top-down DP
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        List<Map<Integer, Integer>> maps = new ArrayList<>();
        
        for (int i = 0; i < A.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int length = 1 + maps.get(j).getOrDefault(diff, 1);
                map.put(diff, length);
                res = Math.max(res, length);
            }
            maps.add(map);
        }
        
        return res;
    }
}