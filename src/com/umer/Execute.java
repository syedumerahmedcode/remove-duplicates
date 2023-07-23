package com.umer;

import com.umer.common.LinkedList;

public class Execute {
	
	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		ll.createLinkedList(1);
		ll.insertNode(2);
		ll.insertNode(3);
		ll.insertNode(4);
		ll.insertNode(5);
		
		ll.traversalLinkedList();
	}

}
