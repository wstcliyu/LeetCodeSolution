// https://leetcode.com/problems/car-fleet-ii/discuss/1085987/JavaC%2B%2BPython-O(n)-Stack-Solution
// Most voted solution from lee215

// Explanation
// We care about the collision time of the cars in front us.
// We iteratre from the last to the first car,
// and we main a stack of car indices,
// where their collision time is strict decreasing.

// Imagine a,b,c on the road
// if the a catches b later than b catched c,
// then a won't catch b but b+c.

// Time: O(N), Space: O(N)
class Solution {
	public double[] getCollisionTimes(int[][] A) {
        int n = A.length;
        Deque<Integer> stack = new LinkedList<>();
        double[] res = new double[n];
        for (int i = n - 1; i >= 0; --i) {
            res[i] = -1.0;
            int p = A[i][0], s = A[i][1];
            while (stack.size() > 0) {
                int j = stack.peekLast(), p2 = A[j][0], s2 = A[j][1];
                if (s <= s2 || 1.0 * (p2 - p) / (s - s2) >= res[j] && res[j] > 0)
                    stack.pollLast();
                else
                    break;
            }
            if (stack.size() > 0) {
                int j = stack.peekLast(), p2 = A[j][0], s2 = A[j][1];
                res[i] = 1.0 * (p2 - p) / (s - s2);
            }
            stack.add(i);
        }
        return res;
    }
}