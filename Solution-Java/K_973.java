// Quick Select
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        helper(points, 0, n - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private void helper(int[][] points, int l, int r, int k) {
        int i = quickSelect(points, l, r);
        if (i - l > k - 1) {
            helper(points, l, i - 1, k);
        } else if (i - l < k - 1) {
            helper(points, i + 1, r, k + l - i - 1);
        }
    }
    
    private int quickSelect(int[][] points, int l, int r) {
        swap(points, r, l + new Random().nextInt(r - l + 1));
        int[] pivot = points[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (getDistanceSquare(points[j]) < getDistanceSquare(pivot)) {
                swap(points, i++, j);
            }
        }
        swap(points, i, r);
        return i;
    }
    
    private void swap(int[][] points, int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
    
    private int getDistanceSquare(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}