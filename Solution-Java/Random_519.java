// Similar with Random_710
class Solution {
    int R, C, total;
    Map<Integer, Integer> map;
    Random rand;

    public Random_519(int n_rows, int n_cols) {
        R = n_rows;
        C = n_cols;
        total = R * C;
        map = new HashMap<>();
        rand = new Random();
    }

    public int[] flip() {
        int i = rand.nextInt(total--);

        // The following 3 lines actually swap the stored values of key i and total
        int res = map.getOrDefault(i, i);
        map.put(i, map.getOrDefault(total, total));
        // Adding this line  so that we don't need to clear the map for reset because map.clear() takes O(n) time
        map.put(total, res);
        
        return new int[]{res / C, res % C};
    }

    public void reset() {
        total = R * C;
    }
}