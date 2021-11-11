package set;

public class BSTSet {
	TNode root = null;	//define root
	
	public BSTSet() {//1,1
		root = null; //equate root to null
		
	}
	
	public BSTSet(int[] input) {
		
		int []sortedInput = insertionSort(input);//efficiently sort array from least to greatest
		
		root = recursivePopulate(0, sortedInput.length-1,sortedInput);//call recursive function with bounds of array end being length of array subtract one
	
	}
	
	public boolean isIn (int v) {//nlogn, 1
		
		TNode r = root;//define r as root of tree: index 0 of array
		
		while(r != null) {
			if(v < r.element) { //check left sub tree as r is greater than current element
				r = r.left; 
			}
			else if(v>r.element) {//check right sub tree as v is greater than current element
				r = r.right;
			}
			
			else if(r.element == v) {//return true if element and v are the same
				return true;
			}
		}
		
		return false; //will only exit while loop if value is null so return false
	}
	
		public void add(int v) {//nlogn,1
			TNode r = root;//define r as root of tree: index 0 of array
			
			
			if(r == null) {//if tree is empty exit function early
				root = new TNode(v,null,null); //equate v to the root of tree
				
				return; 
			}
			
			while(true) {//keep while running until a break
				if(v < r.element) { //check left sub tree as r is greater than current element
					if(r.left == null) {
						r.left = new TNode(v,null,null); //insert value
						break;
					}
					r = r.left;
				}
				else if(v>r.element) {//check right sub tree as v is greater than current element
					if(r.right == null) {
						r.right = new TNode(v,null,null); //insert value as the right subtree root
						break;
					}
					r = r.right;
				}
				
				else if(r.element == v) {
					break;				//break out of loop if element and v are the same
					
				}
			
			}	
		}
		

		public int BSTToArray(TNode r, int[] element, int indx) {//converts BST set to Array recursive function
			
			if( r == null) {  //if nothing in node return indx
				return indx;
			}
						
			indx = BSTToArray(r.left, element, indx); //recursive call of function to go through left subtree
			
			element[indx++] = r.element; //increment indx using element array and equate to current element
			
			indx = BSTToArray(r.right, element, indx); //recursive call of function to go through right subtree and store it in same place as left subtree
			
			
			return indx; //return indx
		}

		public int [] BSTToArray() {
			
				int[] element = new int [this.size()]; //make a new array of the size of tree
				
				int index = 0; //initialize index to 0
				
				BSTToArray(root, element, index); //function call to get array
				
				return element; //return array
						
			}
		
		
		public BSTSet unionTemp(BSTSet s) {//function that does union operation //n,n
			
			if(this.size() ==0) {
				if(s.size()==0) {	// if both sets have a size of 0 return a new BSTSet thats empty
					return new BSTSet();
				}
				else {
			      
					int [] newBSTArray = s.BSTToArray(); //convert the set s to an array using BSTToArray Method
					
					 return new BSTSet(newBSTArray); //return a new BSTSet of the array values
				}
			}
			
			int [] newBSTArray = this.BSTToArray(); //convert the set this to an array using BSTToArray Method
			
			BSTSet newBSTSet = new BSTSet(newBSTArray); //create a new BSTSet of the array values
			
			int [] sBSTArray = s.BSTToArray(); //convert the set s to an array using BSTToArray Method
			
			for(int i=0; i<sBSTArray.length;i++) {
				newBSTSet.add(sBSTArray[i]); //add elements of array to new BSTSet but does not add values already in set
				
			}
			
			return newBSTSet; //return the BSTSet
			
		}
		
		
		public int size() {//get size of BSTSet 
			
			int i = 0; //counting variable
			
			
			if(root==null) {//return 0 when tree is empty
				return i;
			}
			
			return recursiveSize(root, i); //call recursive function
			 	
			}
		
		private int recursiveSize(TNode t, int count){//n,1
			
			
			if(t!=null){//if tree is not empty
				count = 1; //initialize count to 1 to allow counting one time per node
				
				count+= recursiveSize(t.left, count);//goes down left child
				 //get nodes in tree
				count+= recursiveSize(t.right, count); //goes down right child
			
				return count; //return total node value
			
			}
			
		return 0; //if empty return zero
		
	}
		
		
		public BSTSet intersection(BSTSet s) {//big theta n,n
			
			int sSize = s.size(); //size of s tree
			int thisSize = this.size(); //size of this tree
			 
			if(thisSize == 0 || sSize==0) {//if both trees empty
					return new BSTSet(); //return empty set
			}
			
			int [] sBSTArray = s.BSTToArray(); //convert s set to an array
			
			
			BSTSet newBSTSet = new BSTSet(); //create new BSTSet
			
			for(int i=0; i<sBSTArray.length;i++) {//go through s Array 
				if(this.isIn(sBSTArray[i])){ // if a value from this is in s 
					
					newBSTSet.add(sBSTArray[i]); //add the common values of both sets into the newBSTSet
				}
			}
			
			int [] newArray = newBSTSet.BSTToArray(); //convert the BST set into an array
			

			 return new BSTSet(newArray); //return a new BST set of the array with intersection values
			
		}
		
		public TNode recursiveErase(int a,TNode r) {//recursive function for remove: nlogn, 1
			
			if(r.left == null && r.right ==null ) {//check if node has no children
				if(r.element == a) {//if the node now equals the input parameter a
					return null;		//get rid of node value completely
				}
			}
		
			else if(r.right == null) {//check and see if right child does not exist
				if(r.element == a) {//if the node now equals the input parameter a
					return r.left;//return right child in order to delete it
				}
				
				else {
						return recursiveErase(a, r.left);//call recurscive to keep going through tree until a is found on left child
				}
			}
			
			else  if(r.left == null) {//check and see if left child does not exist
				if(r.element == a) {//if the node now equals the input parameter a
					return r.right; //return left child in order to delete it
					
				}
				else {
					return recursiveErase(a, r.right);//call recurscive to keep going through tree until a is found on right child
					
				}
			}
			
			else {//two children case
					
					if(r.element==a) {//check and see if node is equal to integer a
						r.element = Minimum(r.right); //deletes "a" value and gives new root the lowest value so tree remains efficient
						r.right = recursiveErase(r.element, r.right);//call recursive statement to delete the extra r.element that is at minimum leaf on the right subtree

					}
					
					else if(r.element> a) {
						return recursiveErase(a, r.right);//call recurscive to keep going through tree until a is found on right child

					}
			
					else if(r.element<a) {
						return recursiveErase(a, r.left);//call recurscive to keep going through tree until a is found on left child

					}
			}
			
			return r; //return updated tree
		
		}
		
		public int Minimum(TNode minTree){//function to get minimum node of tree
			
			TNode transverseNode= minTree;//define a TNode as minTree
			
			while(transverseNode.right == null && transverseNode.left == null) {//while loop with condition that runs until node has no children
				transverseNode = transverseNode.left; //goes through tree until lowest leaf on the left is found
			}
			
			return transverseNode.element; //return element of minimum leaf
			
		}
		
		public boolean remove(int v) {//remove function
			if(isIn(v) == false) {//if value is not in set
				return false; //return false
			}
			
			root = recursiveErase(v, root); //call recursive method to remove v
			
			return true;//function returns true
		}
		

	public BSTSet difference(BSTSet s) {// big theta n, big theta n
			
		int [] currBSTArray = this.BSTToArray(); //call BSTToArray to convert this BST set to array
		int [] sBSTArray = s.BSTToArray(); //call BSTToArray to convert s BST set to array
		
		BSTSet newBSTSet = new BSTSet();// create a new BSTSet
		
		for(int i=0; i<sBSTArray.length;i++) {//for loop goes through all elements in s set
			if(!this.isIn(sBSTArray[i])){//if s set elements are not in this set 
				
				newBSTSet.add(sBSTArray[i]);//add those s set elements to the newly created BSTSet
			}
		
		}
		
		for(int j =0; j<currBSTArray.length; j++ ) {////for loop goes through all elements in this set
			if(!s.isIn(currBSTArray[j])){//if this set elements are not in s set 
				
				newBSTSet.add(currBSTArray[j]);//add those this set elements to the newly created BSTSet that already has the elements that are in this set but not set
			}
			//add does not add duplicate elements
		}
		
		return newBSTSet; //return the BSTSet
		
		}
		
		public int height() {//function returns a call of the recursiveHeight function to get height of tree
			
			return recursiveHeight(root);
		}
		
		public int recursiveHeight(TNode r) {//nlogn, 1
			
			int height; //initialize return variable

			if (r== null) {//if tree is empty return -1
				return -1;
			}
			else {//if not
				
			
			int leftHeight = recursiveHeight(r.left); //recursively call function to get height of left subtree
			
			int rightHeight = recursiveHeight(r.right);//recursively call function to get height of right subtree
			
			
			height = rightHeight; //make height equal to the right subtree height
			
            if(leftHeight > height ){//if height of the left subtree is greater than the right subtree
				height = leftHeight;//make height equal to the left subtree height
					
				}

				height += 1; // add 1 to the value of the height for the root of the tree
					
			}
			
			return height; //return the height value	
			
		}
		
	public int[] insertionSort(int[] words){//O(n), 1
		//  insertion sort algorithm
		    int i,j;
		    int key;
		    for (i = 1; i < words.length; i++) {
		        key = words[i];
		        j = i - 1;

		        while (j >= 0) {
		            //  compare 
		            if(words[j]<=key) {
		                break;
		            }
		            words[j + 1] = words[j];
		            j = j - 1;
		        }
		        words[j + 1] = key;
		    }
		
		    return words;
	
	}
	
	public TNode recursivePopulate(int start,int end, int[] input) {//big theta n, big theta n
		
		TNode top = null; //define new TNode value as null
		
		
		if(start>end) {//base case to ensure that recursion only occurs in the bounds of the sorted array as if this if is true then the condition is not met
			return top;//return null to not add to tree
		}
		 
		else {
			
			int middle = (start + end)/2; //find middle of array by finding average
			
			top = new TNode (input[middle],null,null); //call TNode so middle of input array element is the root of tree
			
			top.left = recursivePopulate(start,middle-1,input); //recursively populate tree left side by going through first part of array which is elements before middle element of array
			top.right = recursivePopulate(middle+1,end,input);  //recursively populate tree right side by going through second part of array which is elements after middle element of array

		}
		
		return top; //return tree
		
	}
	
	public TNode getRoot()
    {
    	return root;//returns root of set
    }
    
	public  void printBSTSet() {
		if(root==null) {//when set is empty
			System.out.println("The set is empty");
		}
		
		else {
			System.out.print("The set elements are: ");
			printBSTSet(root);//call printBSTSet which prints in increasing order
			System.out.print("\n");
			}
		}
	
	private void printBSTSet(TNode t){
		if(t!=null){//if t is not empty
			printBSTSet(t.left);// prints left subtree of t
			System.out.print(" " + t.element + ", ");
			printBSTSet(t.right); // prints right subtree of t 
		}
		
	}
	
	public void printNonRec() {//Inorder traversal //n,n
	
		if(root!= null){//if root is not empty
            MyStack stack = new MyStack(); //create new Stack
            TNode t = root;//define TNode type variable to root

            while(t!= null) //while loop runs as long as root is not empty
            {
                stack.push(t); //push the root of tree, which is the current node
                t = t.left; //go to the left child and assign it to the current node, t
            }
            while(!stack.isEmpty()) //while the stack is not empty and the current node is not null
            {
                t = stack.pop(); //pop the node on top of the stack: root
                System.out.print(t.element + ", "); //print the value in the node

                if(t.right != null)//go to the right child and check that its not equal to null
                {
                    t = t.right;	//go to the right child and assign it to the current node, t

                    while(t!= null) //while the current node t is not equal to null
                    {
                        stack.push(t); //push the current node onto the stack
                        t = t.left; //go to the left child and assign it to the current node, t
                    }
                }
           }
		}
        else
            System.out.print("Binary Tree is empty");  //else statement for if root is null the tree is empty
    }


	public void printLevelOrder() //n,n
    {
        TNode t = root; //equate t to root
        if(t!= null) //if root, t is not equal to null
        {
            MyQueue q = new MyQueue(); // create an empty queue
            q.enqueue(t); //enqueue the root 

            while(!q.IsEmpty()) //while the q is not empty
            {
                TNode node = q.dequeue(); //dequeue node
                System.out.print(node.element + ", "); //print the value of the node

                if(node.left != null) //if left child of node is not null
                    q.enqueue(node.left); //enqueue the left child
                if(node.right != null) //if right child of node is not null
                    q.enqueue(node.right); //enqueue the right child
            }
        }
        else 
            System.out.print("Binary tree is empty"); //else statement for if root is null the tree is empty
    }

	
	public BSTSet union(BSTSet s) {//union bonus
		int sArray [] =  s.BSTToArray(); //create array from s BSTSet using BSTToArray method
		int thisArray [] = this.BSTToArray(); //create array from this BSTSet using BSTToArray method
		
		int sSize = s.size(); //get the size of s set
		int thisSize = this.size(); //get the size of this set
		
		int [] newArray = new int [sSize + thisSize]; //worst case array for union is if both sets are added and array is the length of both sets combined
		
		int count =0; //index variable
		
		for(int i =0; i<sSize; i++ ) { //for loop goes through size of s set
			newArray[count]= sArray[i]; //newArray of count is equal to values of s set 
			count++; //increment count
		}
		
		for(int j =0; j<thisSize; j++) { //for loop goes through size of this set
			
			if(!s.isIn(thisArray[j])) { ////if this set elements are not in s set 
				newArray[count] = thisArray[j]; //equate newArray of count to the this set elements
				count++; //increment count
			}
			
		}
		
		newArray = shrinkArray(newArray, count); //removing worst case place holder spots that are empty by calling function shrink array
		
		return new BSTSet(newArray); //return a new BSTSet of the array: newArray		
	}
	
	public int[] shrinkArray(int[] old, int newSize) {//shrinks the worst case array if there are empty array elements
		
		int [] smaller = new int [newSize]; //make new array of size newSize 
		
		
		for(int i =0; i<newSize; i++) {//go through size of new array
			smaller[i] = old[i]; //put values into the new array that has the correct amount of spots
		}
		
		return smaller; //return the new array smaller		
	}
}