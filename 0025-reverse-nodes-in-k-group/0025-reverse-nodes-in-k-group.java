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

    public ListNode reverse(ListNode start, ListNode nextGroup){
        ListNode prev = null;
        ListNode curr = start;
        ListNode fnext = null;

        while(curr != nextGroup){
            fnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fnext;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while(true){
            ListNode kth = prevGroup;

            for(int i = 0; i < k; i++){
                kth = kth.next;

                if(kth == null)
                    return dummy.next;
            }

            ListNode start = prevGroup.next;
            ListNode nextGroup = kth.next;
            ListNode newHead = reverse(start, nextGroup);
            prevGroup.next = newHead;
            start.next = nextGroup;
            prevGroup = start;
        }
    }
}