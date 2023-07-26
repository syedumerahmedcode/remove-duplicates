# Removing duplicates from an unsorted linked list

## Table of content

- [Introduction](#introduction)
- [Out Of Scope](#out-of-scope)
- [Removing Duplicates](#removing-duplicates)
- [Project structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Prerequisities](#prerequisities)
- [Commands](#commands)
- [Contribution](#contribution)
- [References](#references)
- [Contact Information](#contact-information)

## Introduction

In this project, we Write a method to remove duplicates from an unsorted linked list.

For Example;

    linkedList = 1->2->1->3
    deleteDups(linkedList)
    //Output
    1->2->3



## Out Of Scope

Since this is an beginner project in which the focus is just to learn some basic usages of an array, testing is out of scope of this project.


## Removing Duplicates

We write a service called _DuplicateNumberRemovalService_ which, when given an unsorted linked list, removes duplicate numbers from the input. For example:

```text
removeDuplicates({1, 1, 2, 2, 3, 4, 5}) ---> Output : [1, 2, 3, 4, 5]
```

Let's have a look at this is done, shall we? 

Initially, we call **deleteDuplicates()** which  takes a linked list as input. Here,we define a _HashSet_ and we start with the _head_ of the linked list as the _currentNode_, previous node is set to _null_ and we iterate through the linked list as long as _current != null_. 

Inside the while loop, we get the value of the _currentNode_ and check if the _hashset_  contains the value already. 

If yes, we set _prev.next = current.next;_ and proceed further.

If the value does not exist in the _hashset_, we add it to the hashset and we set _prev = current;_

After both conditions, _current_ node is always set to _current.next_.

The java code is as follows:

```java
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
```

**Visual description of pseudo code**

![RemoveDuplicatesFromAnUnsortedLinkedList](https://github.com/syedumerahmedcode/remove-duplicates/blob/master/src/main/resources/RemoveDuplicatesFromAnUnsortedLinkedList.jpg)

## Project structure

There are in total three packages: one of which is the _service_ which contain the solution inside a _Service_ class. The other one is the _base_ package which contains the infrastructure for creating a linked list, in this case a singly linked list. These service classes are instantiated and called from _main()_ inside the Execute class which can be found inside _com.umer.main_ package.

## Technologies Used

- Java 11.

## Prerequisities

None.

## Commands

In order to run the program, one needs to open the project in a suitable IDE(such as Eclipse, STS, VSCode or IntelliJ), navigate to the Execute class inside com.umer.main package. Once there, right click---> Run As ---> Java Application.

The program is written in such a way that the service currently uses hard-coded values and it does not take any input from the user. However, one can go inside the main() inside Execute class and change the input parameters as one sees fit.

## Contribution

Feature requests, issues, pull requests and questions are welcome.

## References

- [1](https://bechtle.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/): Data Structures and Algorithms from Zero to Hero and Crack Top Companies 100+ Interview questions (Java Coding) **(Udemy)** **(Primary resource)**



## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv).