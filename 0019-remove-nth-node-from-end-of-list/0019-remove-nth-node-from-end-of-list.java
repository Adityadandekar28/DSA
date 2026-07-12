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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode (-1);
        dummy.next = head;

        ListNode First = dummy;
        ListNode Second = dummy;

        for(int i=0; i<n; i++){
            Second = Second.next;

        }
        while(Second.next !=  null){
            First = First.next;
            Second = Second.next;
        }
        First.next= First.next.next;
        return dummy.next;
    }
}