// https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/discuss/1598941/JavaC%2B%2BPython-All-shortest-paths-have-the-same-cost
// Solution from lee215
class Solution {
	public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0, i = startPos[0], j = startPos[1], x = homePos[0], y = homePos[1];
        while (i != x) {
            i += (x - i) / Math.abs(x - i);
            res += rowCosts[i];
        }
        while (j != y) {
            j += (y - j) / Math.abs(y - j);
            res += colCosts[j];
        }
        return res;
    }
}