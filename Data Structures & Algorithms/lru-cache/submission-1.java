class Node{
    Node prev;
    Node next;
    int key;
    int val;
    public Node(int key, int val)
    {
        this.val = val;
        this.key = key;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new Node(0 , 0);
        right = new Node(0, 0);
        cache = new HashMap<Integer, Node>();
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            removeNode(node);
            insert(node);
            return node.val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value)
    {
        if (capacity == 0) return;
        if(cache.containsKey(key))
        {
            removeNode(cache.get(key));  
            cache.remove(key);
        }
        if(cache.size() == capacity)
        {
            Node lru = left.next;
            cache.remove(lru.key);
            removeNode(lru);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
    }

    private void insert(Node node)
    {
        Node prev = right.prev;
        right.prev = node;
        node.prev = prev;
        prev.next = node;
        node.next = right;
    }

    private void removeNode(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */