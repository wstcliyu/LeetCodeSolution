class Solution:
    # O(n) Sliding Windown(Min)
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l, total, res = 0, 0, 0
        for r, num in enumerate(nums):
            total += num
            while total >= target:
                if res == 0 or res > r - l + 1:
                    res = r - l + 1
                total -= nums[l]
                l += 1
        return res



    # O(nlogn) Binary Search
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        sums = [0]
        total, res = 0, 0
        for r, num in enumerate(nums):
            total += num
            sums.append(total)
            l = self.myBinarySearch(sums, total - target, r + 1)
            if l != -1 and res == 0 or res > r - l + 1:
                res = r - l + 1
        return res
    
    
    def myBinarySearch(self, sums: List[int], total: int, r: int) -> int:
        l = 0
        while l < r:
            m = l + (r - l) // 2
            if sums[m] <= total:
                l = m + 1
            else:
                r = m
        return r - 1