// Iteration #1
func postorderTraversal(root *TreeNode) []int {
    res, stack := []int{}, []*TreeNode{}
    node := root
    for len(stack) > 0 || node != nil {
        if node != nil {
            res = append([]int{node.Val}, res...)
            stack = append(stack, node)
            node = node.Right
        } else {
            node = stack[len(stack) - 1].Left
            stack = stack[:len(stack) - 1]
        }
    }
    return res
}



// Iteration #2
func postorderTraversal(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }
    res, stack := []int{}, []*TreeNode{root}
    for len(stack) > 0 {
        node := stack[len(stack) - 1]
        stack = stack[:len(stack) - 1]
        res = append([]int{node.Val}, res...)
        if node.Left != nil {
            stack = append(stack, node.Left)
        }
        if node.Right != nil {
            stack = append(stack, node.Right)
        }
    }
    return res
}