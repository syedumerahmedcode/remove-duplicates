package com.umer.main;

import com.umer.base.LinkedList;
import com.umer.service.DeleteDuplicatesService;

public class Execute {
	
	public static void main(String[] args) {
		LinkedList linkedList=new LinkedList();
		linkedList.createLinkedList(1);
		linkedList.insertNode(2);
		linkedList.insertNode(3);
		linkedList.insertNode(2);
		linkedList.insertNode(4);
		linkedList.insertNode(4);
		linkedList.insertNode(4);
		linkedList.insertNode(5);
		linkedList.insertNode(4);
		
		System.out.println("The current state of the linked list is:");
		linkedList.traversalLinkedList();
		
		DeleteDuplicatesService deleteDuplicatesService=new DeleteDuplicatesService();
		deleteDuplicatesService.deleteDuplicates(linkedList);
		
		System.out.println("The current state of the linked list after deleting duplicates is:");
		linkedList.traversalLinkedList();
	}

}
