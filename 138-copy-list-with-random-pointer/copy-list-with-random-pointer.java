/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        //base case
        if(head == null){
            return null;
        }
        
        // For store newLLNode refer to oldLLNode...
        HashMap<Node, Node> m = new HashMap<>();

        // New LL head created
        Node newHead = new Node(head.val);

        //PTR on old & new LL
        Node oldTemp = head.next;
        Node newTemp = newHead;
        
        // Stores newHead for oldHead
        m.put(head, newHead);

        // Created Clone LL using next ref var.
        while(oldTemp != null){
            Node copyNode = new Node(oldTemp.val);

            m.put(oldTemp, copyNode);

            newTemp.next = copyNode;
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        // Iterate again to upadte random ref var. of Clone LL
        oldTemp = head;
        newTemp = newHead;

        while(oldTemp != null){
            // assign the newLLRandom ref
            newTemp.random = m.get(oldTemp.random);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}