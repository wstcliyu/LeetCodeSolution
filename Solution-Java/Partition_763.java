// Time Complexity: O(N), where N is the length of SS.
// Space Complexity: O(1) to keep data structure last of not more than 26 characters.
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int prev = -1;
        int rightmost = 0;
        for (int i = 0; i < s.length(); i++) {
            rightmost = Math.max(rightmost, last[s.charAt(i) - 'a']);
            if (rightmost <= i) {
                res.add(i - prev);
                prev = i;
                rightmost = i;
            }
        }
        return res;
    }
}