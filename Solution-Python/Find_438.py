from collections import defaultdict

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        if len(s) < len(p):
            return res
        freq = defaultdict(int)
        for c in p:
            freq[c] += 1
        left, right, count = 0, 0, len(p)
        while right < len(s):
            if freq[s[right]] > 0:
                count -= 1
            freq[s[right]] -= 1
            right += 1
            if count == 0:
                res.append(left)
            if right - left == len(p):
                freq[s[left]] += 1
                if freq[s[left]] > 0:
                    count += 1
                left += 1
        return res