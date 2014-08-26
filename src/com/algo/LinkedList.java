package com.algo;

public class LinkedList {
	
	private Node head;
	
	private Node tail;
	
	public LinkedList(Integer headValue){
		head = new Node(headValue);
		tail=head;
	}
	public Node getHead() {
		return head;
	}



	public void setHead(Node head) {
		this.head = head;
	}



	public Node getTail() {
		return tail;
	}



	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	
	public void add(Integer value){
		Node next = new Node(value);
		tail.setNext (next);
		tail=next;
	}
	
	public void mergeSeparateSorted(){
		Node firstTail = getSeparator();
		Node itrSecond = firstTail.next;
		Node itrFirst = head;
		
		if (itrFirst.value > itrSecond.value){
			//swap
			Integer temp = itrFirst.value;
			
		}
		
	}
	
	public  Node getSeparator(){
		Node itr = head;
		while (itr.next!= null && itr.next.value > itr.value){
			itr = itr.next;
		}
		System.out.println(itr.next.value);
		return itr;
	}
	
	public void print() throws InterruptedException{
		Node itr = head;
		System.out.println("head value " + head.getValue());
		
		while (itr.getNext()!=null){
			Thread.sleep(1000);
			System.out.println(" value = " + itr.getValue());
			itr = itr.getNext();
		}
		System.out.println(" value = " + itr.getValue());
	}
	
	public void reverse() throws InterruptedException{
		Node oldhead = head;
		head.reverse();
		oldhead.next = null;
		
	}
	
	public static LinkedList createFromArray(Integer[] intArray){
		if (intArray == null || intArray.length==0){
			return null;
		}
		
		LinkedList ll = new LinkedList(intArray[0]);
		for (int i=1; i<intArray.length;i++){
			ll.add(intArray[i]);
		}
		return ll;
	}
	
	public static void main(String[] argc) throws InterruptedException{
		LinkedList linkedList = new LinkedList(10);
		linkedList.add(5);
		linkedList.add(9);
		linkedList.add(7);
		linkedList.reverse();
		
		linkedList.print();
	
		
	}
	
	class Node {
		private Integer value;
		
		private Node next;
		
		Node(Integer value){
			this.value = value;
			next = null;
		}
		
		Node(Integer value,Node next){
			this.value = value;
			this.next = next;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		public void reverse() throws InterruptedException{
			// check if we are at penultimate node
			
			if (this.next.next == null){
				// we are at the last but one
				// mark tail as head
				
				head = this.next;
				//reverse the link
				head.next = this;
				//System.out.println(" head value = " + head.value);
				Thread.sleep(1000);
				return;
				
			}
			this.next.reverse();
			this.next.next = this;
			
			
		}
		
	}

}
