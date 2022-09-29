package studentCoursesBackup.driver;

// importing file
import java.io.File;

//importing exceptions
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.io.IOException;

// importing scanner
import java.util.Scanner;

//importing  ArrayLList as we are using this data structure for storing data
import java.util.ArrayList;

//importing supporting classes within same package
import studentCoursesBackup.models.CourseInfo;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.models.Student;

/**
 * @author Dhanashree V Borkar
 */
public class Driver {


	/**
	* This class is for reading input from files and processing and 
	* allocating courses as per student preferences, 
	* it act as run point for this project as it has main method in it
    * @param args
	*/
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 2/*5*/ || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {//|| args[2].equals("${arg2}")
				//|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}

		//try block 
        try{    
			//allocating memory to Arraylist for storing couseInfo and Result
			ArrayList<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
        	ArrayList<Student> studentAllocatedCourseList = new ArrayList<Student>();
			//allocating memory to FileProcessor class, as it has methods to store courseinfo and allocate courses to students 
			FileProcessor FileProcessorObj= new FileProcessor();
            // reading file
		    for (int i = 0; i < args.length; i++) {
				//System.out.printf("args[%d]=%s\n", i, args[i]);
				// read file providing relative path
				File file = new File("..//studentCoursesBackup//src//"+args[i]);
		      	Scanner myfile = new Scanner(file);
    
		      	/**While loop check each line and reading single line input each time and process it
				 */
      			while (myfile.hasNextLine()){
      				//reading the data from input files
      				if(i==0) {
      					/** storing course info details to arraylist data structure to use it while accolating subjects
						*processing input of courseInfo.txt
						*/
      					courseInfoList.add(FileProcessorObj.storeCourseInfo(myfile.nextLine()));
      				}else if(i==1) {
      					/**processing input from coursePrefs.txt and allocating courses as per preferences line by line,
						* one record at a time, not storing student preference anywhere directly processing it.
						*/
      	      			Student studentObj= FileProcessorObj.allocateCourses(courseInfoList,myfile.nextLine());
      	      			studentAllocatedCourseList.add(studentObj);
      				}
	  				}
			}
			//printing results after course allocation
			Results resultsObj = new Results();
			/**Printing course distribution result */
		    resultsObj.printStudentCourseDecisionResult(studentAllocatedCourseList);
			/**Printing conflict errors occured during course distribution*/
			resultsObj.printStudentErrResults(studentAllocatedCourseList);
			resultsObj.printStudentConflictResults(studentAllocatedCourseList);

          // catch block to hadle the error
          }catch(FileNotFoundException e){
			e.printStackTrace();
          }catch(IOException ioe){
			ioe.printStackTrace();
          }catch(Exception e){
			e.printStackTrace();
          }
		   finally{
			
		  }   		  				
		
	}
	

}
