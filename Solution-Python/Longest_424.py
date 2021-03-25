from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, maxCount = 0, 0
        freq = defaultdict(int)
        for r, c in enumerate(s):
            freq[c] += 1
            maxCount = max(maxCount, freq[c])
            if r - l + 1 > maxCount + k:
                freq[s[l]] -= 1
                l += 1
        return len(s) - l