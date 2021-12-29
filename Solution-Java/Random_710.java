// Approach 3: Virtual Whitelist
// Similar with Random_519
// Time Complexity: O(B) preprocessing. O(1) pick.
// Space Complexity: O(B).
class Solution {
    Random rand;
    int M;
    HashMap<Integer, Integer> map;

    public Random_710(int N, int[] blacklist) {
        rand = new Random();
        M = N - blacklist.length;
        map = new HashMap<>();
        for (int b : blacklist)
            map.put(b, 0);
        for (int b : blacklist) {
            if (b >= M) continue;
            while (map.containsKey(--N))
                map.remove(N); // Deleting this line is also OK
            map.put(b, N);
        }
    }

    public int pick() {
        int r = rand.nextInt(M);
        return map.getOrDefault(r, r);
    }
}




// Approach 2: Binary Search over Blacklist
// Time Complexity: O(BlogB) preprocessing. O(logB) pick.
// Space Complexity: O(B). Or O(1) if in-place sort is used and input array is not considered extra space.
class Solution {
    int n;
    int[] b;
    Random rand;

    public Solution(int n, int[] blacklist) {
        this.n = n;
        Arrays.sort(blacklist);
        this.b = blacklist;
        this.rand = new Random();
    }
    
    public int pick() {
        int k = rand.nextInt(n - b.length);
        int l = 0, r = b.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (b[m] > m + k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l + k;
    }
}