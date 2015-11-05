//Given an Iterator class interface with methods: next() and hasNext(), 
//design and implement a PeekingIterator that support the peek() operation
//-- it essentially peek() at the element that will be returned by the next call to next().
//
//Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
//
//Call next() gets you 1, the first element in the list.
//
//Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
//
//You call next() the final time and it returns 3, the last element. 
//Calling hasNext() after that should return false.
//
//Hint:
//
//Think of "looking ahead". You want to cache the next element.
//Is one variable sufficient? Why or why not?
//Test your design with call order of peek() before next() vs next() before peek().
//For a clean implementation, check out Google's guava library source code.
//Follow up: How would you extend your design to be generic and work with all types, not just integer?
//
//Credits:
//Special thanks to @porker2008 for adding this problem and creating all test cases.
//
//Subscribe to see which companies asked this question
package _284_PeekingIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.iterator = iterator;
	    try {
			p = this.iterator.next();
		} catch (java.util.NoSuchElementException e) {
			p = null;
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (p==null)
	    	throw new java.util.NoSuchElementException();
        return p;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer r = p;
		p = iterator.hasNext()?iterator.next():null;
	    if (r==null)
	    	throw new java.util.NoSuchElementException();
	    return r;
	}

	@Override
	public boolean hasNext() {
	    return p!=null;
	}

	private Integer p;
	private Iterator<Integer> iterator;
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		PeekingIterator p = new PeekingIterator(l.iterator());
		System.out.println(p.peek());
		System.out.println(p.next());
		System.out.println(p.peek());
		System.out.println(p.hasNext());
		System.out.println(p.next());
		System.out.println(p.peek());
		System.out.println(p.next());
		System.out.println(p.hasNext());
	}

}
