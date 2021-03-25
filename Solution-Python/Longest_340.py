from collections import defaultdict

class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        freq = defaultdict(int)
        l = 0
        for c in s:
            freq[c] += 1
            if freq[c] == 1:
                k -= 1
            if k < 0:
                freq[s[l]] -= 1
                if freq[s[l]] == 0:
                    k += 1
                l += 1
        return len(s) - l