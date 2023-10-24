# complexity-and-sorting

In this assignment, you’ll work in groups to create a sorting algorithm for geometric shapes. You’ll also implement and perform experimental analysis on six sorting algorithms.

# Instructions

This assignment consists of three parts, to be completed outside of class time. See the course outline and Brightspace for due dates. Complete this assignment with your assigned group.

## Part A: Create a Sorting Application (95 marks)

1. Using the specifications below, create an application to sort objects. You’ll then implement and perform experimental analysis on six sorting algorithms: <br />
   • Bubble <br />
   • Insertion <br />
   • Selection <br />
   • Merge <br />
   • Quick <br />
   • A sorting algorithm of your choice <br />
   You must research the sorting algorithm of your choice and ensure that it’s significantly different from the other five. Include a detailed description of this sort’s algorithm and a complexity analysis in your submission. <br />

## Part B: Complete a Peer Assessment (5 marks)

Each student must also complete a peer assessment of their group members. Your instructor will provide further submission details.

## Part C: Complete an Application Evaluation as a Group

After completing your sorting application, check your work against the provided marking criteria. Your instructor will refer to your group’s self-evaluation when grading the assignment and will

**Shell Sort Program ReadMe**

### Introduction

This Java program provides an implementation of the Shell Sort algorithm to sort an array of shapes. You can use this program to measure the performance of Shell Sort compared to other sorting algorithms like Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, and Quick Sort.

### Installation

1. Ensure you have Java installed on your system.
2. Download the source code of this program, which includes the `partA` package containing the `SortBenchmark` class.
3. Compile the program using the Java compiler. Open your command prompt or terminal and navigate to the directory containing the program's source code. Compile the program using the following command:

### Usage

After compiling the program, you can use it as follows:

1. Load Shape Data:

- Ensure you have shape data files ready. You may customize the data or use the provided data.
- Run the program with the following command, providing the path to your shape data files as arguments:

2. Adjust Comparison Type (Optional):

- By default, the program compares shapes based on volume ('v'). If you want to compare shapes based on their base area ('a'), you can modify the `comparisonType` variable in the source code.
- Locate the `char comparisonType = 'v';` line in the `main` method and change it to `char comparisonType = 'a';` if needed.

3. Run the Program:

- Execute the program with the updated settings using the command:

4. View Sorting Results:

- The program will execute Shell Sort along with other sorting algorithms (Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, and Quick Sort) on the shape data.
- It will display the time taken by each sorting algorithm to sort the data in milliseconds.

### Example

Suppose you want to sort shape data stored in the files `shapes1.txt`, `shapes2.txt`, and `shapes3.txt` based on base area ('a'):

1. Compile the program (if not already compiled).
2. Execute the program as follows:

3. The program will output the time taken by each sorting algorithm to sort the provided shape data based on base area.

### Note

- You can easily modify the program to support additional sorting algorithms or custom sorting criteria.
- Feel free to customize the program as needed for your specific use case.
