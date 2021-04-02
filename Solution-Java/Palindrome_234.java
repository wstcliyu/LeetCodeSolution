class Palindrome_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode endOfFirstHalf = getEndOfFirstHalf(head);
        ListNode startOfSecondHalfReversed = reverseLinkedList(endOfFirstHalf.next);
        ListNode tail = startOfSecondHalfReversed;
        while (tail != null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        reverseLinkedList(startOfSecondHalfReversed);
        return true;
    }
    
    private ListNode getEndOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverseLinkedList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}