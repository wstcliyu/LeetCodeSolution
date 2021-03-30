// Iteration #1
func preorderTraversal(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }
    res, stack := []int{}, []*TreeNode{}
    node := root
    for len(stack) > 0 || node != nil {
        if node != nil {
            res = append(res, node.Val)
            stack = append(stack, node)
            node = node.Left
        } else {
            node = stack[len(stack) - 1].Right
            stack = stack[:len(stack) - 1]
        }
    }
    return res
}



// Iteration #2
func preorderTraversal(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }
    res, stack := []int{}, []*TreeNode{root}
    for len(stack) > 0 {
        node := stack[len(stack) - 1]
        stack = stack[:len(stack) - 1]
        res = append(res, node.Val)
        if node.Right != nil {
            stack = append(stack, node.Right)
        }
        if node.Left != nil {
            stack = append(stack, node.Left)
        }
    }
    return res
}