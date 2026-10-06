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
 
 //here the others node are returning as the nxt node for prev node
 // and for last node is return as for head node 
 // we are combine this both condition cases to write our code
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null){
            return head1 == null ? head2 : head1; // which LL is end opposite to it we return the Node.
        }

        if(head1.val <= head2.val){
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } 
        else{
            head2.next =  mergeTwoLists(head1, head2.next);
            return head2;
        }

    }
}