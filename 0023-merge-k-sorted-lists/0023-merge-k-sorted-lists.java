/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Priority Queue to store the nodes, ordered by their values
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        
        // Add the head of each non-empty list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        
        // Dummy node to help build the result list easily
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        // Process the heap until empty
        while (!pq.isEmpty()) {
            // Get the smallest node from the queue
            tail.next = pq.poll();
            tail = tail.next;
            
            // If the popped node has a next node, add it to the queue
            if (tail.next != null) {
                pq.add(tail.next);
            }
        }
        
        return dummy.next;
    }
}