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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );
        for(ListNode node : lists){
            if(node != null){
                q.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!q.isEmpty()){
            ListNode ref = q.poll();
            tail.next = ref;
            tail = ref;
            if(ref.next != null){
                q.offer(ref.next);
            }
        }

        return dummy.next;
    }
}