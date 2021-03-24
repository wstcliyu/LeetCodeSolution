from collections import defaultdict

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq = defaultdict(int)
        l, repeat = 0, 0
        for r in range(len(s)):
            freq[s[r]] += 1
            if freq[s[r]] == 2:
                repeat += 1
            if repeat > 0:
                freq[s[l]] -= 1
                if freq[s[l]] == 1:
                    repeat -= 1
                l += 1
        return len(s) - l