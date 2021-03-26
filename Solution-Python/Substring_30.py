from collections import defaultdict

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        res = []
        wl = len(words[0])
        freq = defaultdict(int)
        for w in words:
            freq[w] += 1
        for i in range(wl):
            start = i
            count = len(words)
            seen = defaultdict(int)
            for end in range(start + wl, len(s) + 1, wl):
                tail = s[end - wl: end]
                if tail in freq:
                    seen[tail] += 1
                    if seen[tail] <= freq[tail]:
                        count -= 1
                    if end - start == wl * len(words):
                        if count == 0:
                            res.append(start)
                        head = s[start: start + wl]
                        seen[head] -= 1
                        if seen[head] < freq[head]:
                            count += 1
                        start += wl
                else:
                    start = end
                    count = len(words)
                    seen = defaultdict(int)
        return res