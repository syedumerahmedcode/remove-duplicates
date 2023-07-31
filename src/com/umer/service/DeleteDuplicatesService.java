package com.umer.service;

import java.util.HashSet;

import com.umer.base.LinkedList;
import com.umer.base.Node;

public class DeleteDuplicatesService {

	public void deleteDuplicates(LinkedList linkedList) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Node current = linkedList.head;
		Node prev = null;
		while (current != null) {
			int currentValue = current.value;
			if (hs.contains(currentValue)) {
				// delete this node from the linked list
				prev.next = current.next;
				linkedList.size--;
			} else {
				hs.add(currentValue);
				prev = current;
			}
			current = current.next;
		}
	}
	
}
