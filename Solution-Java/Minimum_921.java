// My solution counting left and right (Approach 4 in Longest_32)
class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (++right > left) {
                    res++;
                    left = 0;
                    right = 0;
                }
            }
        }
        return res + left - right;
    }
}