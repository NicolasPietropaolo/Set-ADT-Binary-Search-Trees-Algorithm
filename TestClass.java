package set;

public class TestClass {
	public static void main(String[] args){
		
		//constructor test
		System.out.println("");

		System.out.println("Testing constructors");
		int[] a = {7,4,13,3,6,10,14,1,8};
		
		BSTSet b = new BSTSet(a);
		b.printBSTSet();
		BSTSet c = new BSTSet();
		c.printBSTSet();
		
		//add tests
		System.out.println("");

		System.out.println("Testing add");

		c.add(1);
		c.printBSTSet();
		b.add(-1);
		b.add(203);
		b.add(7);
		b.printBSTSet();


		//isIn test
		System.out.println("");

		System.out.println("Testing isIn");

		c.isIn(1);
		System.out.println(c.isIn(1));
		if (b.isIn(4)) {
			System.out.println("print true");
		}
		
		else {
			System.out.println("print false");
		}
	
		//Size test
		
		System.out.println("");
		System.out.println("Testing size");
		
		int[] z = {7,4,11,3,2,10,14,1,9}; //9 elements size = 9
		int[] y = {7,4,11}; // 3 elements
		int [] x = {}; //empty
		
	BSTSet zz = new BSTSet(z);
	BSTSet yy = new BSTSet(y);
	BSTSet xx = new BSTSet(x);
	
	System.out.println(xx.size());
	System.out.println(yy.size());
	System.out.println(zz.size());

	//BSTToArray test
	
	System.out.println("");	
	System.out.println("Testing BSTToArray");

	
	 int [] aa = zz.BSTToArray() ; 
	 
	 
	 for(int i = 0; i<aa.length; i++) {
		 System.out.printf(aa[i] + " ");
		 	 
	 }
	 
	//height test
		
	System.out.println("");	
	System.out.println("Testing height");
	
	
	int[] d6 = {2, 4, 6, 8, 11, 10, 14, 15, 18, 24, 22, 35, 28, 29};
	BSTSet aa1 = new BSTSet(d6);
	
	int aa2 = aa1.height();
	
	System.out.println(aa2);
	
	}

}
