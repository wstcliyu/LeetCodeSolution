// O(n) Sliding Windown(Min)
func minSubArrayLen(target int, nums []int) int {
    res := math.MaxInt32
    l, sum := 0, 0
    for r := 0; r < len(nums); r++ {
        sum += nums[r]
        for sum >= target {
            if res > r - l + 1 {
                res = r - l + 1
            }
            sum -= nums[l]
            l++
        }
    }
    if res == math.MaxInt32 {
        return 0
    } else {
        return res
    }
}



// O(nlogn) Binary Search
func minSubArrayLen(target int, nums []int) int {
    sums := []int{0}
    sum := 0
    res := math.MaxInt32
    for r := 0; r < len(nums); r++ {
        sum += nums[r]
        sums = append(sums, sum)
        l := myBinarySearch(sums, sum - target, r + 1)
        if l != -1 && res > r - l + 1 {
            res = r - l + 1
        }
    }
    if res == math.MaxInt32 {
        return 0
    } else {
        return res
    }
}

func myBinarySearch(sums []int, sum int, r int) int {
    l := 0
    for l < r {
        m := l + (r - l) / 2
        if sums[m] <= sum {
            l = m + 1
        } else {
            r = m
        }
    }
    return r - 1
}