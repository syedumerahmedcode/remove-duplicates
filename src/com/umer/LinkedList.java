package com.umer;

public class LinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	public void createLinkedList(int nodeValue) {
		Node newNode=new Node();
		newNode.value=nodeValue;
		newNode.next=null;
		head=newNode;
		tail=newNode;
		size=1;
	}
}
