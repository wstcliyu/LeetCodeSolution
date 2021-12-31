// DP
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = i-1; j >= 0 && !dp[i]; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i)))
                    dp[i] = true;
            }

            // Alternative
            // for (String word : wordDict) {
            //     int len = word.length();
            //     if (len <= i && dp[i - len] && word.equals(s.substring(i-len, i))) {
            //         dp[i] = true;
            //         break;
            //     }
            // }
        }
        return dp[N];
    }
}




// Recursion with memoization
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}




// BFS
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        visited[0] = true;
        q.addLast(0);
        while (!q.isEmpty()) {
            int start = q.removeFirst();
            for (String word : wordDict) {
                int len = word.length();
                int end = start + len;
                if (end <= n && word.equals(s.substring(start, end))) {
                    if (end == n) return true;
                    if (!visited[end]) {
                        visited[end] = true;
                        q.addLast(end);
                    }
                }
            }
        }
        return false;
    }
}
