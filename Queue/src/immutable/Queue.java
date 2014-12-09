package immutable;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Thierry Edson
 * this class represents an immutable Queue .
 * @rep List<E> elements: [cup,cars,books,Spaces] // queue of string
 * @rep int size : 4 // number of element in the queue
 */
public class Queue <E> {
	
	/*
	* the observer deQueue_top
	* the  producer deQueue_pop
	* the Observer isEmpty
	* the remaining private methods are created for mere internal usage.
	*  
	*  Abstraction function is
    *   AF(r)=([r.elements(0),r.elements(1),...,r.elements(size-1)]size)
    *   
    *  Representation Invariant is:
    *  1)  the rep-invariant (size) must be equal to elements.size()
    *  2)  if size>0  there must not be an element in the queue 
    *  3)  no elements in the queue must be null
	*/
	private List<E> elements;
    private int size;
	
	 public Queue() {   // constructor: creates and initializes an empty stack
		 
		      this.elements = new ArrayList<E>();
		      this.size=0; 
		      
		      repOK(); //check if the rep holds when the object is created;
		      
	    	}
	 
	 
	 private Queue(Queue<E> e){  // private constructor used internally
		 		 this.elements=new  ArrayList<E>(e.elements);
		 		 this.size = e.size;
		 	}
	 
	
	
	 
	 public Queue<E> enQueue(E e){// producer: adds a new element in the Queue
		 repOK();//check if the rep holds before the operation
		Queue<E> list2 = new Queue<E>(this);
		list2.elements.add(e);
		list2.size=list2.size+1;  
		repOK();//check if the rep holds after the operation
		return new Queue<E>(list2);

	}
	
	
	public E  deQueue_top() {  /*Observer: return the first element(elements(0)) of the Queue */
		
		if (elements.size()==0) throw new IllegalStateException("Queue is already empty");
		repOK();//check if the rep holds before the operation
		E elt=elements.get(0);
		repOK();//check if the rep holds after the operation
		return elt;
	}
	public Queue<E> deQueue_pop(){ // producer: return the new Queue(old Queue deprived of the the first element) 
		
		if (elements.size()==0)  throw new IllegalStateException("Queue is already empty");
		repOK();//check if the rep holds before the operation
		Queue<E> q=new Queue<E>(this);
		q.elements.remove(0);
		q.size--;
		repOK();//check if the rep holds after the operation
		return q; 
		
	}  
	
	
	public boolean isEmpty(){ // return true if the Queue is empty or false otherwise
		
		return size==0;
		
	}
	
	public String toString(){ // return the queue
		String queue="([";
		for(int i=0 ;i<this.size-1; i++){
			
			queue=queue+"" +elements.get(i)+",";
			
		}
		queue=queue+""+elements.get(this.size-1)+"]"+size+")";
		return queue;
	}
	
	public boolean repOK(){ //check is the representation invariant holds 
		
		//1)  the rep-invariant size must be equal to elements.size()
		if(size!=elements.size()) throw new IllegalStateException("size different from rep.size");
		
		//2)  if size>0  there must not be an element in the queue 
		if((size>0)&&(elements==null)) throw new IllegalStateException("no element but size>0");
		
		if(size>0)
		for(int i=0 ;i<size;i++){
		//3)no elements in the queue must be null
			if (elements.get(i)==null) throw new IllegalStateException("element enter is null ");
		}
		return true;
	}
	
	public  int set_size(){return size=size+1;} /*WARNING: this method has been create just to increment the size without 
	*adding an element in the Queue. It aims at proving the efficiency of repOK in checking the REP-INVARIANT "1" & "2" above.
	*In real life it will not be part of the implementation. 
	*/
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	Queue<String> q=new Queue<String>();
	
	q=q.enQueue("me");
	q=q.enQueue("edson");
	q=q.enQueue("thierry");
	q=q.enQueue("noumessi");
	System.out.println(q);
	q=q.deQueue_pop();
	System.out.println(q);
	q=q.deQueue_pop();
	System.out.println(q.toString());
	
		
	
	}

}

