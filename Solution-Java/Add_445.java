// Use stack to reverse linkedlist
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int c = 0;
        ListNode head = null;
        while (!s1.empty() || !s2.empty() || c > 0) {
            if (!s1.empty()) c += s1.pop();
            if (!s2.empty()) c += s2.pop();
            ListNode node = new ListNode(c % 10);
            c /= 10;
            node.next = head;
            head = node;
        }
        return head;
    }
}




// Reverse 2 linked lists, then same as Add_2
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            // keep the next node
            ListNode tmp = head.next;
            // reverse the link
            head.next = last;
            // update the last node and the current node
            last = head;
            head = tmp;    
        }    
        return last;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // get the current values 
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;
            
            // current sum and carry
            int val = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;
            
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
            
            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }

        return head;
    }
}




// Follow-up: do not reverse input
// 1. Add 2 lists by aligning digit, reverse without considering carry
// 2. Reverse and take carry into account
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // find the length of both lists
        int n1 = 0, n2 = 0;
        ListNode curr1 = l1, curr2 = l2;
        while (curr1 != null) {
            curr1 = curr1.next; 
            ++n1;    
        }
        while (curr2 != null) {
            curr2 = curr2.next; 
            ++n2;    
        }
            
        // parse both lists
        // and sum the corresponding positions 
        // without taking carry into account
        // 3->3->3 + 7->7 --> 3->10->10--> 10->10->3
        curr1 = l1; 
        curr2 = l2;
        ListNode head = null;
        while (n1 > 0 && n2 > 0) {
            int val = 0;
            if (n1 >= n2) {
                val += curr1.val; 
                curr1 = curr1.next; 
                --n1;    
            }
            if (n1 < n2) {
                val += curr2.val; 
                curr2 = curr2.next;
                --n2;    
            }
                
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;    
        }

        // take the carry into account
        // to have all elements to be less than 10
        // 10->10->3 --> 0->1->4 --> 4->1->0
        curr1 = head;
        head = null;
        int carry = 0;
        while (curr1 != null) {
            // current sum and carry
            int val = (curr1.val + carry) % 10;
            carry = (curr1.val + carry) / 10;
            
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;

            // move to the next elements in the list
            curr1 = curr1.next;    
        }
        
        // add the last carry
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;    
        }

        return head;
    }
}
