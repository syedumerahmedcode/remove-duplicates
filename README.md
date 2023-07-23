# arrays

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

We write a service called _DuplicateNumberRemovalService_ which, when given an array, removes duplicate numbers from the input array. A key assumption here is that input array is in sorted order. For example:

```text
removeDuplicates({1, 1, 2, 2, 3, 4, 5}) ---> Output : [1, 2, 3, 4, 5]
```

Let's have a look at this is done, shall we? 

Initially, we call **public int[] removeDuplicatesForSortedElements(int[] sortedInputArray)**. Inside this method, we call **removeDuplicates(sortedInputArray, sortedInputArray.length)** which contains the heart of the logic(described in detail soon).

```java
int result = removeDuplicates(sortedInputArray, sortedInputArray.length);
```

Once we get back the result(which is essentially the number of unique elements in the array), we iterate through the initial array till the number of distinct elements and return the new (shortened) array.  

```java
int[] newArray = new int[result];
// Here, we loop through input array again but we only go till the length as
// indicated by the place holder from the helper method.
for (int i = 0; i < result; i++) {
	newArray[i] = sortedInputArray[i];
}
return newArray;
```


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