class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        endOfFirstHalf = self.getEndOfFirstHalf(head)
        startOfSecondHalfReversed = self.reverseLinkedList(endOfFirstHalf.next)
        tail = startOfSecondHalfReversed
        while tail:
            if tail.val != head.val:
                return False
            tail = tail.next
            head = head.next
        self.reverseLinkedList(startOfSecondHalfReversed)
        return True
        
    def getEndOfFirstHalf(self, head: ListNode) -> ListNode:
        fast, slow = head, head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        return slow
    
    def reverseLinkedList(self, head: ListNode):
        newHead = None
        while head:
            temp = head.next
            head.next = newHead
            newHead = head
            head = temp
        return newHead