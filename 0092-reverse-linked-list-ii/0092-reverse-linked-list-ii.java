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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode (0);
         dummy.next = head;

        ListNode second = dummy;
        ListNode first = head;

        for(int i=0; i<left-1;i++){
            first = first.next;
            second = second.next;
        }
        ListNode postNode = first;
        ListNode preNode = second;

        ListNode current= first;
        ListNode pre= null;
        for(int i=0;i<= right-left;i++){
            ListNode post = current.next;
            current.next= pre;
            pre= current;
            current = post;
        }
        preNode.next= pre;
        postNode.next= current;

return dummy.next;

    }
}