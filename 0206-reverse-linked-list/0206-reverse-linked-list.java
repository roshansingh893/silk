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
import java.util.*;

class Solution {
       public ListNode reverseList(ListNode head) {
        // Initialize previous pointer to null
        ListNode prev = null;

        // Start from the head of the list
        ListNode temp = head;

        // Traverse the list
        while (temp != null) {
            // Save the next node
            ListNode front = temp.next;

            // Reverse the current node's pointer
            temp.next = prev;

            // Move prev to current node
            prev = temp;

            // Move to the next node
            temp = front;
        }

        // Return new head (last node becomes first)
        return prev;
    }
}
