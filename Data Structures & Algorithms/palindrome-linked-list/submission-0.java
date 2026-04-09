/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode s = head, f = head;
        while(f != null && f.next != null)
        {
            s = s.next;
            f = f.next.next;
        }

        ListNode prev = null, next = null, cur = s;
        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next; 
        }

        while(head != null && prev!= null)
        {
            if(head.val != prev.val)
            {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;

    }
}