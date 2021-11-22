class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int a, b, c = 0;
        while (l1 != null || l2 != null || c > 0) {
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                b = 0;
            } else {
                b = l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode((a + b + c) % 10);
            p = p.next;
            c = (a + b + c) / 10;
        }
        return dummy.next;
    }
}