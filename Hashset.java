//time complexity: average case: O(1), worst case could go O(n): depending upon the number of collisions
//space complexity: O(n): size of the array we are creating
//Yes, I have solved on leetcode

class MyHashSet {

    /** Initialize your data structure here. */
   ListNode[] arr = new ListNode[10000];
    
    public MyHashSet() {
       
    }
    
    public void add(int key) {
        int index = gethash(key); // got the index where key should be present
        if(arr[index] == null){
            arr[index] = new ListNode(-1); // no node at that index
        }
        ListNode prev = getElement(arr[index], key); // got previous node where key is present
        if(prev.next == null){
            prev.next = new ListNode(key); // if no node, add new node with given key
        }
        else
            return;
       
    }
    
    public void remove(int key) {
        int index = gethash(key);//got index where key should be present
        if(arr[index] == null) return;
        ListNode prev = getElement(arr[index], key); // got previous node where key should be present
        if(prev.next == null) return;
        else{
            prev.next = prev.next.next; // remove the node with given key
        }
    
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
       int index = gethash(key); //get index where key should be present
        if(arr[index] == null) return false;
        ListNode prev = getElement(arr[index], key);
        return prev.next != null; // true if node with key is not present
    }
    
    // returns index where key should be present
    public int gethash(int key){
        return key%arr.length;
    }
    
    //we traverses the linkedlist at array index, to search for the previous node of the key
    public ListNode getElement(ListNode head, int key){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
}
class ListNode{
    int key;
    ListNode next;
    
    ListNode(int key){
        this.key = key;
        next = null;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */