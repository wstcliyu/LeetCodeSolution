// Mono queue
func maxSlidingWindow(nums []int, k int) []int {
    res, q := []int{}, []int{}
    for i, num := range nums {
        for len(q) > 0 && q[0] <= i - k {
            q = q[1:]
        }
        for len(q) > 0 && nums[q[len(q) - 1]] <= num {
            q = q[:len(q) - 1]
        }
        q = append(q, i)
        if i - k + 1 >= 0 {
            res = append(res, nums[q[0]])
        }
    }
    return res
}



// Two pass
func maxSlidingWindow(nums []int, k int) []int {
    n := len(nums)
    res, left, right := make([]int, n - k + 1), make([]int, n), make([]int, n)
    for i := 0; i < n; i++ {
        if i % k == 0 {
            left[i] = nums[i]
        } else {
            if left[i - 1] > nums[i] {
                left[i] = left[i - 1]
            } else {
                left[i] = nums[i]
            }
        }
        j := n - 1 - i
        if j % k == 0 || j == n - 1 {
            right[j] = nums[j]
        } else {
            if right[j + 1] > nums[j] {
                right[j] = right[j + 1]
            } else {
                right[j] = nums[j]
            }
        }
    }
    for i := 0; i < n - k + 1; i++ {
        if left[i + k - 1] > right[i] {
            res[i] = left[i + k - 1]
        } else {
            res[i] = right[i]
        }
    }
    return res
}