class LRUCache {

    static class Node{
        int key, val;
        Node prev;
        Node next;
        public Node(int k, int v){
            key = k;
            val = v;
            prev = next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    HashMap<Integer, Node> m = new HashMap<>();
    int limit;

//================ LL OPERATION ================================

    // add at begining as MRU
    void addNode(Node newNode){ // O(1)
        Node oldNext = head.next;

        // side PTR point to newNode
        head.next = newNode;
        oldNext.prev = newNode;

        //update PTR of newNode
        newNode.next = oldNext;
        newNode.prev = head;

    }

    // delete from end as LRU
    void delNode(Node oldNode){// O(1)
        // delNode prev & nxt finded
        Node oldPrev = oldNode.prev;
        Node oldNext= oldNode.next;

        // side PTR updated
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

//====================== LRU ===================================

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    // No need of swap the Nodes just CUT the get fun KEY then Add it as MRU in First
    public int get(int key) {
        if(!m.containsKey(key)){
            return -1;
        }
        
        // Retrive Data of get(key) Node
        Node ansNode = m.get(key);
        int ans = ansNode.val;

        //delete it where it is
        m.remove(key);
        delNode(ansNode);
        //We just cut it from LL Not destroyed

        // Add as MRU in first
        addNode(ansNode);
        m.put(key, ansNode);
    
        return ans;
    }
    
    public void put(int key, int value) {

        //============== EDGE CASES=========================
        // key already exist
        // Delete that Node => No need of size check tichi jaga khali hoil
        if(m.containsKey(key)){
            Node oldNode = m.get(key);
            delNode(oldNode);
            m.remove(key);
        }
        
        // Not Already then check size
        // size is reached

        if(m.size() == limit){
            //delete LRU data
            m.remove(tail.prev.key); // we use tail for LRU
            delNode(tail.prev);
        }

        //============== ADD CONDITION ============================

        // Add NewNode after space is created by delNode 
        // OR Space is already have then no need of delNode
        //also alredy exsist OR not
        //size reached OR not

        Node newNode = new Node(key, value);

        addNode(newNode);
        m.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */