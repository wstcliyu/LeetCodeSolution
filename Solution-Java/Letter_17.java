// Backtrack
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(digits.toCharArray(), res, new StringBuilder());
        return res;
    }
    
    private String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private void backtrack(char[] digits, List<String> res, StringBuilder sb) {
        if (sb.length() == digits.length) {
            res.add(sb.toString());
        } else {
            for (char c : mapping[digits[sb.length()] - '2'].toCharArray()) {
                sb.append(c);
                backtrack(digits, res, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}




// BFS
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) {
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            for (int j = res.size(); j > 0; j--) {
                String s = res.removeFirst();
                for (char c : mapping[digits.charAt(i) - '2'].toCharArray()) {
                    res.addLast(s + c);
                }
            }
        }
        return res;
    }
    
    private String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
}