// My favorite one is Approach 5 and Approach 6
// Approach 6 has the best space complexity O(N)




// Approach 1: Backtracking
class Solution {

    public int minCut(String s) {
        return findMinimumCut(s, 0, s.length() - 1, s.length() - 1);
    }

    private int findMinimumCut(String s, int start, int end, int minimumCut) {
        // base condition, no cut needed for an empty substring or palindrome substring.
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }

        for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex++) {
            // find result for substring (start, currentEndIndex) if it is palindrome
            if (isPalindrome(s, start, currentEndIndex)) {
                minimumCut = Math
                    .min(minimumCut, 1 + findMinimumCut(s, currentEndIndex + 1, end, minimumCut));
            }
        }
        return minimumCut;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}




// Approach 2: Dynamic Programming - Top Down (Recursion, Memoization)
class Solution {

    private Integer memoCuts[][];
    private Boolean memoPalindrome[][];

    public int minCut(String s) {
        memoCuts = new Integer[s.length()][s.length()];
        memoPalindrome = new Boolean[s.length()][s.length()];
        return findMinimumCut(s, 0, s.length() - 1, s.length() - 1);
    }

    private int findMinimumCut(String s, int start, int end, int minimumCut) {
        // base case
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }
        // check for results in memoCuts
        if (memoCuts[start][end] != null) {
            return memoCuts[start][end];
        }
        for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex++) {
            if (isPalindrome(s, start, currentEndIndex)) {
                minimumCut = Math
                    .min(minimumCut, 1 + findMinimumCut(s, currentEndIndex + 1, end, minimumCut));
            }
        }
        return memoCuts[start][end] = minimumCut;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        // check for results in memoPalindrome
        if (memoPalindrome[start][end] != null) {
            return memoPalindrome[start][end];
        }
        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
            && isPalindrome(s, start + 1, end - 1);
    }
}




// Approach 3: Dynamic Programming - Top Down (Optimized Space Complexity)
class Solution {

    private Integer memoCuts[];
    private Boolean memoPalindrome[][];

    public int minCut(String s) {
        memoCuts = new Integer[s.length()];
        memoPalindrome = new Boolean[s.length()][s.length()];
        return findMinimumCut(s, 0, s.length() - 1, s.length() - 1);
    }

    private int findMinimumCut(String s, int start, int end, int minimumCut) {
        // base case
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }
        // check for results in memoCuts
        if (memoCuts[start] != null) {
            return memoCuts[start];
        }
        for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex++) {
            if (isPalindrome(s, start, currentEndIndex)) {
                minimumCut = Math
                    .min(minimumCut, 1 + findMinimumCut(s, currentEndIndex + 1, end, minimumCut));
            }
        }
        return memoCuts[start] = minimumCut;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        // check for results in memoPalindrome
        if (memoPalindrome[start][end] != null) {
            return memoPalindrome[start][end];
        }
        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
            && isPalindrome(s, start + 1, end - 1);
    }
}




// Approach 4: Dynamic Programming - Bottom Up (Tabulation)
// Time: O(N^2)
// Space: O(N^2)
class Solution {
    private Integer cutsDp[];
    private boolean palindromeDp[][];

    public int minCut(String s) {
        cutsDp = new Integer[s.length()];
        palindromeDp = new boolean[s.length()][s.length()];
        // build the palindrome cutsDp for all susbtrings
        buildPalindromeDp(s, s.length());

        for (int end = 0; end < s.length(); end++) {
            int minimumCut = end;
            for (int start = 0; start <= end; start++) {
                if (palindromeDp[start][end]) {
                    minimumCut = start == 0 ? 0 : Math.min(minimumCut, cutsDp[start - 1] + 1);
                }
            }
            cutsDp[end] = minimumCut;
        }
        return cutsDp[s.length() - 1];
    }

    private void buildPalindromeDp(String s, int n) {
        for (int end = 0; end < s.length(); end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 ||
                    palindromeDp[start + 1][end - 1])) {
                    palindromeDp[start][end] = true;
                }
            }
        }
    }
}




// Approach 5: Optimized Tabulation Approach
// Time: O(N^2)
// Space: O(N^2)
class Solution {

    public int minCut(String s) {
        Integer cutsDp[];
        boolean palindromeDp[][];
        cutsDp = new Integer[s.length()];
        palindromeDp = new boolean[s.length()][s.length()];
        for (int end = 0; end < s.length(); end++) {
            int minimumCut = end;
            for (int start = 0; start <= end; start++) {
                // check if substring (start, end) is palidrome
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 ||
                    palindromeDp[start + 1][end - 1])) {
                    palindromeDp[start][end] = true;
                    minimumCut = start == 0 ? 0 : Math.min(minimumCut, cutsDp[start - 1] + 1);
                }
            }
            cutsDp[end] = minimumCut;
        }
        return cutsDp[s.length() - 1];
    }

}




// Approach 6: Expand Around the Center
// Time: O(N^2)
// Space: O(N)
class Solution {

    public int minCut(String s) {
        int cutsDp[];
        cutsDp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            cutsDp[i] = i;
        }
        for (int mid = 0; mid < s.length(); mid++) {
            // check for odd length palindrome around mid index
            findMinimumCuts(mid, mid, cutsDp, s);
            // check for even length palindrome around mid index
            findMinimumCuts(mid - 1, mid, cutsDp, s);

        }
        return cutsDp[s.length() - 1];
    }

    public void findMinimumCuts(int startIndex, int endIndex, int[] cutsDp, String s) {
        for (int start = startIndex, end = endIndex;
            start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
            int newCut = start == 0 ? 0 : cutsDp[start - 1] + 1;
            cutsDp[end] = Math.min(cutsDp[end], newCut);

        }
    }
}