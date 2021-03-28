from collections import deque

class Solution:
    # Mono queue
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res, q = [], deque()
        for i, num in enumerate(nums):
            while q and q[0] <= i - k:
                q.popleft()
            while q and nums[q[-1]] <= num:
                q.pop()
            q.append(i)
            if i - k + 1 >= 0:
                res.append(nums[q[0]])
        return res



    # Two pass
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res, left, right = [], [0] * n, [0] * n
        for i in range(n):
            left[i] = nums[i] if i % k == 0 else max(nums[i], left[i - 1])
            j = n - 1 - i
            right[j] = nums[j] if j % k == 0 or j == n - 1 else max(nums[j], right[j + 1])
        for i in range(n - k + 1):
            res.append(max(left[i + k - 1], right[i]))
        return res