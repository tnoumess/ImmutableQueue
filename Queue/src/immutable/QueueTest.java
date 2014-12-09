package immutable;

import static org.junit.Assert.*;


import org.junit.Test;

public class QueueTest {
	
	private Queue<String> Q1;

	
	
	
	@Test(expected = IllegalStateException.class)
	public void test_constructor() {  //tests if the object has been well created
		/*note: violation number2 of the rep-invariant ; "no element in the queue, but size>0"
		 * this test will fail if we initialize because the size to x!=0(Q1.set_size)
		 * in normal condition(x==0) 
		 * 
		 */
		Q1= new Queue<String>();
		Q1.set_size();//increments size
		assertEquals((boolean)true,Q1.repOK());
		
		//legitimate initialization!
		Q1= new Queue<String>();
		assertEquals((boolean)true,Q1.repOK());
		
		
	}
	
	@Test (expected = IllegalStateException.class)
	public void test_no_null_entry() {  //tests if an entry is  null 
		/*note: violation number3 of the rep-invariant ; "no element must be null" 
		 * this test will throw an ISE because no entries must be null
		 */
		Q1= new Queue<String>();
		Q1=Q1.enQueue(null);
		assertEquals((boolean)true,Q1.repOK());
		
		//legitimate enQueue!
		Q1= new Queue<String>();
		Q1=Q1.enQueue("Good entry");
		assertEquals((boolean)true,Q1.repOK());
		
	}
	@Test (expected = IllegalStateException.class)
	public void test_size_correctness1() { // checks that the rep inv "size" is equal to the number of element in the queue(elements.size())
		/*note: violation number1 of the rep-invariant ; "size!=elements.size()"
		 * the operation do not go through because the rep inv(size) is one to many with respect to elements.size()
		 * Hence, this test will throw an ISE.
		 */
		Q1= new Queue<String>();
		Q1=Q1.enQueue("ronaldo");
		Q1=Q1.enQueue("noumessi");
		Q1.set_size();//increments size
		assertEquals((boolean)true,Q1.repOK());
		
	}
	
	

}