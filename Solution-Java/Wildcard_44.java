// Approach 2: Dynamic Programming
// Time complexity: O(S * P) where S and P are lengths of the input string and the pattern respectively.
// Space complexity: O(S * P) to store the matrix.
class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        // base cases
        if (p.equals(s)) {
            return true;
        }
    
        if (pLen > 0 && p.chars().allMatch(c -> c == '*')) {
            return true;
        }
    
        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }

        // init all matrix except [0][0] element as False
        boolean[][] d = new boolean[pLen + 1][sLen + 1];
        d[0][0] = true;

        // DP compute
        for (int pIdx = 1; pIdx < pLen + 1; pIdx++) {
            // the current character in the pattern is '*'
            if (p.charAt(pIdx - 1) == '*') {
                int sIdx = 1;
                                 
                // d[p_idx - 1][s_idx - 1] is a string-pattern match
                // on the previous step, i.e. one character before.
                // Find the first idx in string with the previous math.
                while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen + 1)) {
                    sIdx++;
                }
    
                // If (string) matches (pattern),
                // when (string) matches (pattern)* as well
                d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1];
    
                // If (string) matches (pattern),
                // when (string)(whatever_characters) matches (pattern)* as well
                while (sIdx < sLen + 1) {
                    d[pIdx][sIdx++] = true;
                }
                          
            // the current character in the pattern is '?'
            } else if (p.charAt(pIdx - 1) == '?') {
                for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1];
                }
    
            // the current character in the pattern is not '*' or '?'
            } else {
                for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    // Match is possible if there is a previous match
                    // and current characters are the same
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                    (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
                }
            }
        }
                                        
        return d[pLen][sLen];
    }
}




// Approach 3: Backtracking
// Time complexity: O(min(S,P)) for the best case and better than O(SlogP) for the average case, 
// where S and P are lengths of the input string and the pattern correspondingly. 
// Please refer to this article (https://arxiv.org/pdf/1407.0950.pdf) <On the Average-case Complexity of Pattern Matching with Wildcards>
// for detailed proof. However, in the worst-case scenario, this algorithm requires O(S * P) time.
// Space complexity: O(1) since it's a constant space solution.
class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {
            // If the pattern caracter = string character
            // or pattern character = '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                ++sIdx;
                ++pIdx;
    
            // If pattern character = '*'
            } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                // Check the situation
                // when '*' matches no characters
                starIdx = pIdx;
                pIdx = starIdx + 1;
                sTmpIdx = sIdx;
                          
            // If pattern character != string character
            // or pattern is used up
            // and there was no '*' character in pattern 
            } else if (starIdx == -1) {
                return false;
                          
            // If pattern character != string character
            // or pattern is used up
            // and there was '*' character in pattern before
            } else {
                // Backtrack: check the situation
                // when '*' matches one more character
                pIdx = starIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }

        // The remaining characters in the pattern should all be '*' characters
        for (int i = pIdx; i < pLen; i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
   
        }
        return true;
    }
}