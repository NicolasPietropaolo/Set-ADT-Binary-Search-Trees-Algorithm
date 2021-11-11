package set;

public class MyStack {
	
	private Node top; 
	
	public boolean isEmpty() {
		
		if(top== null) {//if stack is empty return true 
			return true;
		}
        
		else {// if stack is not empty return false
				return false;
		}
			
    }

    public void push(TNode r)
    {
        top = new Node(r,top); //adding a new node before the created Node top
    }

    public TNode pop()
    {
        if (isEmpty()) { //if the stack is empty print a message
            System.out.println(" the Stack is Empty");
            
            return null; // stack is empty so return nothing
        
        }    
            
        TNode r = top.currentElement; //grabbing current element and equating it to r
        top = top.nextNode;				// references top to the next element in stack
        
        return r; //return current element
    }

    public TNode top() {
    	
    	TNode currentElement = top.currentElement; //shows top element of stack
    
        return currentElement; //return the value
    }
}

