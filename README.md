# Sort Manager Project

## Requirements

### Phase 1
Write a program which will take an array of ints 
and sort it using a bubble sort algorithm 
and then a merge sort algorithm. Include JUnit tests 
for this and all subsequent phases 
(and all subsequent projects for the rest of time).

### Phase 2
Update your project to use MVC and start to 
incorporate some of the design principles discussed 
earlier in the course (OOP, SOLID, design patterns). 
Create classes which implements MVC, including 
SortManager (controller) and a DisplayManager (view) 
classes. The code should include a basic factory 
pattern to determine which sorter to use. Make sure 
packages are created properly and the structure 
follows the MVC pattern. Create an interface which 
both sort classes can implement and make sure your 
application uses this interface where possible.

### Phase 3
Add logging code into the Sort Manager project. 
Set up log4j in the project and add a properties 
file. Create logs at different levels and fully test 
the resulting output. Have output going to the 
console and to a log file created in the resources 
directory. Ensure there are meaningful log messages 
added to the project and that they reflect the needs 
of the levels for which they are set.

### Phase 4
Integrate a new class to implement a binary search 
tree approach for sorting, so that the BST can be 
called in the same way as the other sort algorithms. 
The new class should implement the current Sorter 
interface. Add code that calls the BST and passes 
in the array that will be used to construct the tree 
and then return a sorted array. Use the Facade design 
pattern for this step and implement a nested class 
to represent a node in the tree.

### Phase 5
Add timing information to the project and allow the 
user to select multiple algorithms to compare their 
performance.

## Tools required to run the project
1. IntelliJ IDEA Community or Ultimate Edition
2. Java 17 JDK

## How to use the project
1. Download the repository as shown in the image 
below:

    ![](howToDownload.jpg)
2. Unzip the downloaded file.
3. Paste the folder named "SortManager-main" into your
IntelliJ project directory and rename it to
"SortManager".
4. Open up IntelliJ and load the project
in File > Open, then select SortManager from
your project directory.

