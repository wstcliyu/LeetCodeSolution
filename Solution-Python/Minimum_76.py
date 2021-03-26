from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        res = ""
        freq = defaultdict(int)
        for c in t:
            freq[c] += 1
        l, count = 0, len(t)
        for r, c in enumerate(s):
            freq[c] -= 1
            if freq[c] >= 0:
                count -= 1
            while count == 0:
                if res == "" or r - l + 1 < len(res):
                    res = s[l : r + 1]
                freq[s[l]] += 1
                if freq[s[l]] > 0:
                    count += 1
                l += 1
        return res