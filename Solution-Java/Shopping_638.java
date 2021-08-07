class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shop(price, special, needs, new HashMap<>());
    }
    
    private int shop(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int res = dot(price, needs);
        for (List<Integer> offer : special) {
            List<Integer> clone = new ArrayList<>(needs);
            int i = 0;
            for (; i < needs.size(); i++) {
                int diff = needs.get(i) - offer.get(i);
                if (diff < 0) {
                    break;
                }
                clone.set(i, diff);
            }
            if (i == needs.size()) {
                res = Math.min(res, offer.get(i) + shop(price, special, clone, memo));
            }
        }
        memo.put(needs, res);
        return res;
    }
    
    private int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
}