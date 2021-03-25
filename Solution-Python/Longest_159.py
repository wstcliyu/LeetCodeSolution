from collections import defaultdict

class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        freq = defaultdict(int)
        l, count = 0, 0
        for c in s:
            freq[c] += 1
            if freq[c] == 1:
                count += 1
            if count > 2:
                freq[s[l]] -= 1
                if freq[s[l]] == 0:
                    count -= 1
                l += 1
        return len(s) - l