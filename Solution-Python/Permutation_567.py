from collections import defaultdict

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        freq = defaultdict(int)
        for c in s1:
            freq[c] += 1
        l, r, count = 0, 0, len(s1)
        while r < len(s2):
            if freq[s2[r]] > 0:
                count -= 1
            freq[s2[r]] -= 1
            r += 1
            if count == 0:
                return True
            if r - l == len(s1):
                if freq[s2[l]] >= 0:
                    count += 1
                freq[s2[l]] += 1
                l += 1
        return False