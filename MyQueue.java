package set;

public class MyQueue {
	
	    private Node head;
	    private Node tail; 

	    public MyQueue()        // makes an empty queue
	    {
	      head = new Node(null,null);
	      tail = head;
	    }

	    public boolean IsEmpty()
	    {
	        return head==null;//queue is empty if head is empty
	    }

	    public void enqueue(TNode t)
	    {
	        tail.nextNode = new Node(t,null); //pushing onto the back of the queue
	        tail = tail.nextNode; // updating the back pointer 
	    }

	    public TNode dequeue()
	    {
	        if (IsEmpty()) {//checks if the queue is empty 
	            System.out.println("the Queue is Empty");
	            return null; 				//returns nothing
	        }
	        
	        if (tail==head.nextNode)
	            tail = head; //make tail the head
	        TNode element = head.nextNode.currentElement; //gets correct value of stack by making node after head the current element
	        head.nextNode = head.nextNode.nextNode; //shifts the stack correctly

	        return element; //returns removed value
	    }

}
