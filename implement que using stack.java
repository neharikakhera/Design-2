//time complexity: Push- O(1), Pop- O(n): worst case
//space complexity: O(n): we use two stacks to implement queue
//Yes I have solved on leetcode
//in first stack, we simply push the elements and 2nd stack we use as buffer to get to know the top element
class MyQueue {
    
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
    //To access the top element of stack,
    //if s2 is empty, we need to pop all elements of s1 and add into s2
    
      if(s2.isEmpty()){
          while(! s1.isEmpty())
            s2.push(s1.poll);
      }
        if(s2.empty()) return -1;
        
        return s2.pop();
    }

    // Get the front element
    public int peek() {
        if(s2.isEmpty()){
          while(! s1.isEmpty())
            s2.push(s1.poll);
      }
        if(s2.empty()) return -1;
        
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        //stack is empty if both the s1 and s2 stack is empty
        return (s1.empty && s2.empty());
    }

  }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */