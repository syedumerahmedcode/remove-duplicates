# arrays

## Table of content

- [Introduction](#introduction)
- [Out Of Scope](#out-of-scope)
- [Average Temperature Calculation](#average-temperature-calculation)
- [Find missing number](#find-missing-number)
- [Finding Pairs](#finding-pairs)
- [Search in array](#search-in-array)
- [Max product of two integers](#max-product-of-two-integers)
- [Is unique](#is-unique)
- [Permutation](#permutation)
- [Rotate matrix](#rotate-matrix)
- [Middle of the array](#middle-of-the-array)
- [Sum of Diagonal Elements](#sum-of-diagonal-elements)
- [Finding top 2 best scores](#finding-top-2-best-scores)
- [Duplicate Number Removal](#duplicate-number-removal)
- [Finding Pairs of Sum](#finding-pairs-of-sum)
- [Project structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Prerequisities](#prerequisities)
- [Commands](#commands)
- [Contribution](#contribution)
- [References](#references)
- [Contact Information](#contact-information)

## Introduction

In this project, **arrays** are used to solve various types of interesting problems. What is an array? An _array_ is a data structure of a collection of elements, each of which is identified by an index. The time complexities of 1D and 2D arrays are defined in the diagram below:

**Visual description**

![TimeComplexitiesOf1DAnd2DArrays](https://github.com/syedumerahmedcode/arrays/blob/master/src/main/resources/TimeComplexitiesOf1DAnd2DArrays.jpg)


## Out Of Scope

Since this is an beginner project in which the focus is just to learn some basic usages of an array, testing is out of scope of this project.

## Average Temperature Calculation

We write a Service called _AverageTemperatureService_ which takes number of days and the temperature on that day from the user as input and based on these values not only calculates the average temperature throughout this range but also the number of days on which the temperature recorded is above than the average temperature.

## Find missing number

We write a service called _MissingNumberService_ which takes an integer array containing a number series from _1 till n_ as input and finds out the one missing number in the series. 

It is assumed that the number series is an ascending series which starts from 1 till n but it only skips one number till n. In other words, it does not skip multiple numbers till n. 

First of all, we loop through the array using a for loop in which we calculate _sumFromArrayElements_ and _numberOfElements_. 

```java

int sumFromArrayElements = 0;
int sumUsingMathematicalNumberSeriesFormula = 0;
for (int i : intArray) {
	sumFromArrayElements += i;
}
int numberOfElements = intArray.length + 1;

```

Next, we use the Mathematical formula: 
_Sum of number series from 1,2,3,4,..., (n-2),(n-1),n => n*(n+1)/2_
and then simply find the difference as shown below:

```java

/*
 * 
 * Mathematical formula: Sum of number series from 1,2,3,4,..., (n-2),(n-1),n
 * =>n*(n+1)/2
 * 
 */

sumUsingMathematicalNumberSeriesFormula = numberOfElements * (numberOfElements + 1) / 2;
int difference = sumUsingMathematicalNumberSeriesFormula - sumFromArrayElements;
System.out.println("Missing number is " + difference);

```
Using this approach, we can find the one missing number in the series without having to loop through the array multiple times.  

## Finding pairs

We write a service called _FindingPairService_ which takes an integer array containing several random numbers and a target number which is equal to the sum of a pair of numbers.   

```text
* Examples
* 
* Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] +
* nums[1] == 9, we return [0, 1]
* 
* 
* Input: nums = [3,2,4], target = 6 Output: [1,2]
```

Here, we loop through the array from 0 till the length of the array and inside the for-loop, we loop through a smaller subset of the array, starting from _firstIndex + 1_ till the length of the array. Inside the inner loop, we check if the sum of value at firstIndex and the secondIndex is equal to target number. If yes, the corresponding indices are returned. If the sum is not equal to target, the loop continues.

If nothing is found, even after the outer loop finishes, the _IllegalArgumentException_ is thrown which indicates that no solution is found.

```java
public int[] twoSum(int[] inputOfNumbers, int numberToFind) {
for (int firstIndex = 0; firstIndex < inputOfNumbers.length; firstIndex++) {
	for (int secondIndex = firstIndex + 1; secondIndex < inputOfNumbers.length; secondIndex++) {
		if (inputOfNumbers[firstIndex] + inputOfNumbers[secondIndex] == numberToFind) {
			return new int[] { firstIndex, secondIndex };
		}
	}
}
throw new IllegalArgumentException(NO_SOLUTION_FOUND);
}
```

## Search in array

We write a service called _SearchInArrayService_ which takes an integer array containing several numbers and a target number to search as input and checks if the array contains that number.   

```text
* 
* int[] intArray = {1,2,3,4,5,6}; searchInArray(intArray, 6); // 5
* 
```

We iterate over the complete array and for each index, we check if the value on this index is equal to the target value we are looking for. If this is the case, the index location is returned. If no match is found, -1 is returned.

```java
for (int currentIndex = 0; currentIndex < inputOfNumbers.length; currentIndex++) {
	if (inputOfNumbers[currentIndex] == numberToFind) {
		return currentIndex;
	}
}
return -1;
```

## Max product of two integers

We write a service called _MaxProductService_ which takes an integer array containing several numbers as input and prints out the pair of numbers which yields the maximum product. Here, it is assumed that all numbers in the input array are positive numbers.

Here, we iterate through the input array twice, once through the whole array and once for each index. Inside the inner for-loop, a product of indices is computed and it is checked against the result already stored inside the method. If the new product is higher than the stored value, then the value is updated. Eventually, the pair yielding the highest result is returned as string.

```java
int maxProduct = 0;
String pairWithMaximumProduct = "";
for (int firstIndex = 0; firstIndex < inputArrayOfPositiveNumbers.length; firstIndex++) {
	for (int secondIndex = firstIndex + 1; secondIndex < inputArrayOfPositiveNumbers.length; secondIndex++) {
		final int productOfNumbersAtIndices = inputArrayOfPositiveNumbers[firstIndex]
						* inputArrayOfPositiveNumbers[secondIndex];
		if (productOfNumbersAtIndices > maxProduct) {
			maxProduct = productOfNumbersAtIndices;
			pairWithMaximumProduct = Integer.toString(inputArrayOfPositiveNumbers[firstIndex]) + ","
							+ Integer.toString(inputArrayOfPositiveNumbers[secondIndex]);
		}
	}
}
return pairWithMaximumProduct;
```
        

## Is unique

We write a service called _IsUniqueService_ which takes an integer array containing several numbers as input and checks if all the numbers are unique or not.

Here, we iterate through the input array twice, once through the whole array and once for each index. Inside the inner for-loop, we check if the number at the the index from the outer loop is equal to the number at the the index from the inner loop. If they are equal, it means that the numbers are not unique and _false_ is returned immediately. If no repeating numbers are found until both for-loops are completed then _true_ is returned at the end of the method.

```java
for (int firstIndex = 0; firstIndex < inputArrayToCheck.length; firstIndex++) {
	for (int secondIndex = firstIndex + 1; secondIndex < inputArrayToCheck.length; secondIndex++) {
		if (inputArrayToCheck[firstIndex] == inputArrayToCheck[secondIndex]) {
			return false;
		}
	}
}
return true;
```
 
## Permutation

We write a service called _PermutationService_ which is given two integer arrays and it checks if they are permutation of each other. _Permutation_ refers to any of the various ways in which a set of things can be ordered. 

Here, we first Check if the length is same or not. If there are not of equal length, then the arrays are not permutations of each other.

```java
// Check if the length is same or not. If there are not of equal length, then
// the arrays are not permutations of each other.
if (firstArray.length != secondArray.length) {
	return false;
}
```

Next up, we we check if the sum and the product of the arrays are same or not. If both of these values are equal, then the given arrays are permutations of each other. Finally, we check if both sums as well as both products are equal. If yes, then we know for sure that both arrays are permutations of each other and _true_ is returned. Else _false_ is returned.

```java
// Here, we check if the sum and the product of the arrays are same or not.
// If both of these values are equal, then the given arrays are permutations of
// each other.

int sumOfFirstArray = ZERO;
int sumOfSecondArray = ZERO;
int productOfFirstArray = ONE;
int productOfSecondArray = ONE;

for (int index = 0; index < secondArray.length; index++) {
	sumOfFirstArray += firstArray[index];
	sumOfSecondArray += secondArray[index];

	productOfFirstArray *= firstArray[index];
	productOfSecondArray *= secondArray[index];
}
if (sumOfFirstArray == sumOfSecondArray && productOfFirstArray == productOfSecondArray) {
	return true;
} else {
	return false;
}
```

The advantage of checking sums and products of both arrays is that here, we only need one loop to calculate them since we have already determined that both have equal length(a core condition of both arrays being permutations of each other). Otherwise, a more simpler approach would be do solve this problem using two loops but will result in much poorer performance.   

## Rotate matrix

We write a service called _RotateMatrixService_ which is given an nxn matrix(in the form of a two-dimensional array) as input and rotates it clockwise by 90 degrees. So,the given input would transform into the following output shown below:

```text
[1,2,3]		[7,4,1]		
[4,5,6] 	=>	[8,5,2]
[7,8,9] 		[9,6,3]
```

The pseudo code/process flow of solving this works as follows:

**Visual description**

![RotateImageBy90Degrees](https://github.com/syedumerahmedcode/arrays/blob/master/src/main/resources/RotateImageBy90Degrees.jpg)

We start with the outer most layer and move the edges 90 degrees. One the outermost layer is rotated, we move one level down and repeat the whole process once more. We keep going further inwards till we reach the middle of the matrix/image.

# Implementation in code

We calculate rows and columns and compare them. If they are not equal, then the input is _not_ a nxn matrix/image. Hence, we exit the logic.

```java
int rows = matrixOrImageToRotate.length;
int columns = matrixOrImageToRotate[0].length;
if (rows == 0 || rows != columns) {
	// This means that this is not a nxn matrix. Hence, we should return false.
	return false;
}
```

Now, we find out the number of layers that we need to loop through. Please note that **layers=rows/2**.

Once, inside the layer, we loop through the ceels in the current layer and rotate the edges as shown in the code snippet below:

```java
// find out the number of layers inside the matrix that we need to rotate. hint:
// layers=rows/2.
// Here, we loop through the layers
for (int layer = 0; layer < rows / 2; layer++) {
	int first = layer;
	int last = rows - 1 - layer;
	// Here we loop through the cells on the current layer
	for (int i = first; i < last; i++) {
		// Here, we rotate the edges
		int offset = i - first;
		int top = matrixOrImageToRotate[first][i];
		matrixOrImageToRotate[first][i] = matrixOrImageToRotate[last - offset][first];
		matrixOrImageToRotate[last - offset][first] = matrixOrImageToRotate[last][last - offset];
		matrixOrImageToRotate[last][last - offset] = matrixOrImageToRotate[last][last - offset];
		matrixOrImageToRotate[last][last - offset] = matrixOrImageToRotate[i][last];
		matrixOrImageToRotate[i][last] = top;
	}
}
```
Finally, at the end, _true_ is returned indicating that the rotation was successful.

## Middle of the array

We write a service called _MiddleFunctionService_ which takes a list and returns a new list that contains all but the first and last elements. 

Here, instead of looping through the array and creating a new array without the first and last index, we use the **Arrays.copyOfRange()** method. The code looks like the following:

```java
public int[] findMiddleOfTheArray(int[] inputArray) {
	return Arrays.copyOfRange(inputArray, 1, inputArray.length - 1);
}
```

## Sum of Diagonal Elements

We write a service called _SumOfDiagonalElementsService_ which calculates the sum of diagonal elements when a 2 dimensional array is given as input. 

Here, we loop through the array and calculate the sum of a cell where row and column are the same index. Since the array is already assumed to be 2D(two dimensional) array, we know that rows and columns are the same. Hence, by calculating the sum in this way, we will traverse diagonally in the array.

```java
int sum = 0;
for (int index = 0; index < inputArray.length; index++) {
	sum += inputArray[index][index];
}
return sum;
```
 
## Finding top 2 best scores

We write a service called _BestScoreService_ which, when given an array, gets the first and the second best scores from it. A key point here is that array may contain duplicates(something which will become relevant during the explanation below).

If we were to only solve it using arrays, then we need to loop through the entries of the array once and store highest and second highest numbers in two variables. However, since we do not have any restrictions on using other classes, we are using Collections class.

First we create a duplicate of the input array. Next, we sort the array in descending order. Now, because the array is sorted in descending order, the first element in the array is the biggest number. Second number is initialized to null. Why? Because the input array can contain duplicates so we cannot just blindly take the value at index 1.

We iterate through the length of the array and look out for first number which is different from the first number.	Since, the array is sorted in descending order, we should look for the first number which is different from first number. Why? So that we can avoid duplicates. Now that we have found the second number, there is no need to loop through any further and hence, we break out of the loop.

Finally, the first and second highest number is returned as a string.

```java 
Integer[] tempArray = inputArray;
Arrays.sort(tempArray, Collections.reverseOrder());
int firstNumber = tempArray[0];
Integer secondNumber = null;

for (int index = 0; index < tempArray.length; index++) {
	if (tempArray[index] != firstNumber) {
		secondNumber = tempArray[index];
			break;
	}
}
return firstNumber + " " + secondNumber;
```

## Duplicate Number Removal

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

### int removeDuplicates(int[] sortedInputArray, int arrayLength)

This contains the actual logic for removal of duplicate elements and it happens in the following steps. Firstly, we check if array length is 0 or 1 then return n as this is a boundary condition.

```java
if (arrayLength == 0 || arrayLength == 1) {
	return arrayLength;
}
```
Next up, we create a variable called placeholderForUniqueElements will act as a place holder for how many distinct elements are present in the array. Now, we loop through all the elements and we check if current element is different from next element. If yes, we add it at the place holder location and increment the place holder.

```java
int placeholderForUniqueElements = 0;
for (int i = 0; i < arrayLength - 1; i++) {
	// While looping through all the elements, we check if current element is
	// different from next element
	// If yes, we add it at the place holder location and increment the place holder
	if (sortedInputArray[i] != sortedInputArray[i + 1]) {
		sortedInputArray[placeholderForUniqueElements++] = sortedInputArray[i];
	}
}
```
Finally, we capture the last element and return the place holder for unique elements in the given input array.

```java
// Finally, we capture the last element.
sortedInputArray[placeholderForUniqueElements++] = sortedInputArray[arrayLength - 1];
// return the place holder
return placeholderForUniqueElements;
```

**Q) What if the input array is unsorted?**

In case the input array is unsorted, we can resolve it using **LinkedHashSet** with something like the following:

```java
public void removeDuplicatesFromUnsortedArray(int[] unsortedInputArray) {
LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

// adding elements to LinkedHashSet
for (int index = 0; index < unsortedInputArray.length; index++)
	set.add(unsortedInputArray[index]);

// Print the elements of LinkedHashSet   
System.out.print("Filtered array which does not contain any dupliacte elements: "+set);

}
```

## Finding Pairs of Sum

We create a service called _PairSumService_ containing _findPairsOfSum()_ method which is used to find all pairs of an integer array whose sum is equal to a given number. For example:

```text
pairSum({2, 4, 3, 5, 6, -2, 4, 7, 8, 9},7) Output : "2:5 4:3 3:4 -2:9 "
```

The way to do it is to loop through the input array and inside it loop through the input array once again but starting from one index ahead in the array. Here, we check if the sum of values at first index and second index in the array equals the given number. If yes, we add it in the result string continue traversing through the array till we reach the end of the input array. Eventually, we return the result.

```java
String result = "";
for (int firstIndex = 0; firstIndex < inputArrayToFindPairsIn.length; firstIndex++) {
	for (int secondIndex = firstIndex + 1; secondIndex < inputArrayToFindPairsIn.length; secondIndex++) {
		if (inputArrayToFindPairsIn[firstIndex] + inputArrayToFindPairsIn[secondIndex] == sumToMatch) {
			result += inputArrayToFindPairsIn[firstIndex] + ":" + inputArrayToFindPairsIn[secondIndex] + " ";
		}
	}
}
return result;
```
 


## Project structure

There are several packages, one for each problem, which contain the solution inside a _Service_ class. These service classes are instantiated and called from _main()_ inside the Execute class which can be found inside _com.umer.main_ package.

## Technologies Used

- Java 11.

## Prerequisities

None.

## Commands

In order to run the program, one needs to open the project in a suitable IDE(such as Eclipse, STS, VSCode 0or IntelliJ), navigate to the Execute class inside com.umer.main package. Once there, right click---> Run As ---> Java Application.

The program is written in such a way that most of the service currently uses hard-coded values and it does not take any input from the user(apart from the _AverageTemperatureService_). However, one can go inside the main() inside Execute class and change the input parameters as one sees fit.

## Contribution

Feature requests, issues, pull requests and questions are welcome.

## References

- [1](https://bechtle.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/): Data Structures and Algorithms from Zero to Hero and Crack Top Companies 100+ Interview questions (Java Coding) **(Udemy)** **(Primary resource)**
- [2](https://www.geeksforgeeks.org/java-program-to-remove-duplicate-elements-from-the-array/): Java Program to Remove Duplicate Elements From the Array



## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=%5BGitHub%5D%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv).