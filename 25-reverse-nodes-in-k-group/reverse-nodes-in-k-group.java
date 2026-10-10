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
        ListNode temp = head;
        int cnt = 0;

        //check if k nodes exist
        while(cnt < k){
            if(temp == null){
                return head;
            }
            temp = temp.next;
            cnt++;
        }

        //recursively call for rest of LL
        ListNode prevNode = reverseKGroup(temp, k);

        //reverse current group 
        temp = head; cnt = 0;
        while(cnt < k){
            ListNode next = temp.next;
            temp.next = prevNode;

            prevNode = temp;
            temp = next;

            cnt++;
        }
        return prevNode;
    }
}