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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode curr = head;

        while (true) {
            ListNode[] group = new ListNode[k];
            ListNode temp = curr;

            for (int i = 0; i < k; i++) {
                if (temp == null) return head; 
                group[i] = temp;
                temp = temp.next;
            }

            int i = 0, j = k - 1;
            while (i < j) {
                int swap = group[i].val;
                group[i].val = group[j].val;
                group[j].val = swap;
                i++;
                j--;
            }
            curr = temp;
        }
    }
}
