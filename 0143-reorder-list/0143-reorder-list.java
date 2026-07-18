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
    static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode after = null;
        ListNode prev = null;

        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);
        slow.next = null;

        ListNode st = head;

        while( rev != null){
            ListNode next1 = st.next;
            ListNode next2 = rev.next;

            st.next = rev;
            rev.next = next1;

            st = next1;
            rev = next2;
        }
    }
}