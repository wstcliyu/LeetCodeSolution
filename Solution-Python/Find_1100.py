from collections import defaultdict

class Solution(object):
    def numKLenSubstrNoRepeats(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: int
        """
        if len(S) < K:
            return 0
        freq = defaultdict(int)
        l, r, repeat, res = 0, 0, 0, 0
        while r < len(S):
            freq[S[r]] += 1
            if freq[S[r]] == 2:
                repeat += 1
            r += 1
            if r - l == K:
                if repeat == 0:
                    res += 1
                freq[S[l]] -= 1
                if freq[S[l]] == 1:
                    repeat -= 1
                l += 1
        return res