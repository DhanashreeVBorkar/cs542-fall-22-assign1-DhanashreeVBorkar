package studentCoursesBackup.driver;

// importing file
import java.io.File;

//importing exceptions
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;

//importing  ArrayLList as we are using this data structure for storing data
import java.util.ArrayList;

//importing supporting classes within same package
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.models.Student;

/**
 * @author Dhanashree V Borkar
 */
public class Driver {


	/**
	* This Driver class is for reading input from files and processing and 
	* allocating courses as per student preferences and printing it txt file, 
	* it act as run point for this project as it has main method in it
    * @param args
	*/
	public static void main(String[] args) {
		try{
		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}")|| args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		System.out.println("Please check result in registration_results.txt, error.txt and conflicts.txt");

		/**creating object of FileProcessor as it reads the imput and passes data to courseScheduler to process further */
		FileProcessor fileProcessorObj =new FileProcessor();
		//readInputFromFileAndProcess method reads input and process data in scourseschedular and returns result as arraylist of student
		ArrayList<Student> studentAllocatedCourseList =fileProcessorObj.readInputFromFileAndProcess(args);


		//printing results after course allocation
			Results resultsObj = new Results();
			/**Printing course distribution result */
		    resultsObj.printStudentCourseDecisionResult(studentAllocatedCourseList);
			/**Printing conflict errors occured during course distribution*/
			resultsObj.printStudentErrResults(studentAllocatedCourseList);
			resultsObj.printStudentConflictResults(studentAllocatedCourseList);


	
	//handled exceptions
	}catch(ArrayIndexOutOfBoundsException aie){
		aie.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{}
	

}
}
