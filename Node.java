package set;

public class Node {
	
	public Node nextNode; //reference to next Node
	public TNode currentElement; // element of the current node
	
	public Node(TNode currentElement, Node nextNode) {//constructor for the class node
		this.nextNode = nextNode; //assign value to nextNode
		this.currentElement = currentElement; //assign value to currentElement
		
		
	}
	

}
