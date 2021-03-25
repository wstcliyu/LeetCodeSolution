func longestOnes(A []int, K int) int {
    l := 0
    for _, a := range A {
        if a == 0 {
            K -= 1
        }
        if K < 0 {
            if A[l] == 0 {
                K += 1
            }
            l += 1
        }
    }
    return len(A) - l
}