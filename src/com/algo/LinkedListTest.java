package com.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void mergeSeparateSorted() throws InterruptedException {
		//fail("Not yet implemented"); // TODO
		Integer[] intArray = {1,2,3,4,1,5,8,9};
		LinkedList ll = LinkedList.createFromArray(intArray);
		ll.mergeSeparateSorted();
		ll.print();
	}
	
	@Test
	public void getSeparator() throws InterruptedException {
		//fail("Not yet implemented"); // TODO
		Integer[] intArray = {1,2,3,4,1,5,8,9};
		LinkedList ll = LinkedList.createFromArray(intArray);
		System.out.println(ll.getSeparator().getValue());
	}

	@Test
	public void testReverse() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testCreateFromArray() throws InterruptedException {
		Integer[] intArray = {1,2,3,4,1,5,8,9};
		LinkedList ll = LinkedList.createFromArray(intArray);
		ll.print();
		
	}
	
	@Test
	public void testSubString(){
		
		String test = "Abhijit";
		System.out.println(test.substring(test.length()-1));
		
	}
	
	

}
