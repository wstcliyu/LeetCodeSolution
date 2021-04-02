func isPalindrome(head *ListNode) bool {
    endOfFirstHalf := getEndOfFirstHalf(head)
    startOfSecondHalfReversed := reverseLinkedList(endOfFirstHalf.Next)
    tail := startOfSecondHalfReversed
    for tail != nil {
        if tail.Val != head.Val {
            return false
        }
        tail = tail.Next
        head = head.Next
    }
    reverseLinkedList(startOfSecondHalfReversed)
    return true
}

func getEndOfFirstHalf(head *ListNode) *ListNode {
    fast, slow := head, head
    for fast.Next != nil && fast.Next.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
    }
    return slow
}

func reverseLinkedList(head *ListNode) (newHead *ListNode) {
    for head != nil {
        next := head.Next
        head.Next = newHead
        newHead = head
        head = next
    }
    return
}