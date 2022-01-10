// My solution (refer to approach #2 in Put_1564)
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int i = boxes.length - 1;
        int l = 0, r = warehouse.length - 1;
        int count = 0;
        for (; i >= 0 && l <= r; i--) {
            if (boxes[i] <= warehouse[l]) {
                l++;
                count++;
            } else if (boxes[i] <= warehouse[r]) {
                r--;
                count++;
            }
        }
        return count;
    }
}