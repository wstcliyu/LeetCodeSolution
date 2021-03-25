class Solution:
    def longestOnes(self, A: List[int], K: int) -> int:
        l = 0
        for a in A:
            if a == 0:
                K -= 1
            if K < 0:
                if A[l] == 0:
                    K += 1
                l += 1
        return len(A) - l