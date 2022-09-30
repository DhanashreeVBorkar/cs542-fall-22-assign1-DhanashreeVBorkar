# CSX42: Assignment 1
## Name: Dhanashree Vinayak Borkar

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=courseInfo.txt -Darg1=coursePrefs.txt -Darg2=registration_results.txt -Darg3=conflicts.txt -Darg4=errors.txt



## Replace <fileName.txt> with real file names. For example, if the files are available in the path,
## you can run it in the following manner:

 ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=courseInfo.txt -Darg1=coursePrefs.txt -Darg2=registration_results.txt -Darg3=conflicts.txt -Darg4=errors.txt


Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:

1. For reading input from text file used Scanner, reading single line input and processing it.
2. Used ArrayList Data Structure for storing and processing CourseInfo , Not storing CoursePreferences anywhere , directly processing them one by one
3. Using 2 nested for loops for distributing / allocating courses, so time complexity is O(n)^2 (CourseScheduler class has the methods to allocate courses)
    3.1 first for loop is for reading coursePreference one by one
    3.2 second for loop is for comparing and validating courseinfo for allocating preference course to student
4.Used FileWriter for printing results in output.txt files like regidtration_results.txt, errors.tct and conflicts.txt


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 29 Sep 2022


