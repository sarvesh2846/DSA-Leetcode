/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) { 
        // base case
        if(head == null){
            return head;
        }
        Node curr = head;

        while(curr != null){
            if(curr.child != null){
                //flattern the child nodes
                Node next = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;
                
                //find tail
                Node tail = curr.next;
                
                while(tail.next != null){
                    tail = tail.next;
                }

                //attach tail with next ptr
                if(next != null){
                    tail.next = next;
                    next.prev = tail;
                }
            }

            curr = curr.next;
        }
        return head;
    }
}