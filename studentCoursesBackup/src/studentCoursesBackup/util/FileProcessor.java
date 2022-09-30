package studentCoursesBackup.util;

import java.util.ArrayList;

//importing supporting classes within same package
import studentCoursesBackup.models.CourseInfo;
import studentCoursesBackup.models.Student;

//importing exceptions
import java.io.FileNotFoundException;
import java.io.IOException;


// importing file
import java.io.File;

// importing scanner
import java.util.Scanner;

import studentCoursesBackup.interfaces.FileProcessorInterface;


/**
 * @author Dhanashree V Borkar
 */
public class FileProcessor implements FileProcessorInterface {


/**
	* readInputFromFileAndProcess method is used for reading input
	* from file and process it with CourseScheduler methods
    * @param args
    * @return ArrayList<Student>
	*/
	@Override
	public ArrayList<Student> readInputFromFileAndProcess(String [] args){

		//allocating memory to Arraylist for storing couseInfo and
		// Result
		ArrayList<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
        ArrayList<Student> studentAllocatedCourseList = new ArrayList<Student>();

		//try block 
        try{    
			
			//allocating memory to courseScheduler class object, as it
			// has methods to store courseinfo and allocate courses to students 
			CourseScheduler courseSchedulerObj= new CourseScheduler();
            // reading file
		    for (int i = 0; i < args.length; i++) {
				//System.out.printf("args[%d]=%s\n", i, args[i]);
				// read file providing relative path
				File file = new File("..//studentCoursesBackup//src//"+args[i]);
		      	Scanner myfile = new Scanner(file);
    
		      	/**While loop check each line and reading single
				* line input each time and process it
				 */
      			while (myfile.hasNextLine()){
      				//reading the data from input files
      				if(i==0) {
      					/** storing course info details to arraylist
						* data structure to use it while accolating 
						*subjects processing input of courseInfo.txt
						*/
      					courseInfoList.add(courseSchedulerObj.storeCourseInfo(myfile.nextLine()));
      				}else if(i==1) {
      					/**processing input from coursePrefs.txt and
						* allocating courses as per preferences line
						* by line, one record at a time, not storing
						* student preference anywhere directly 
						* processing it.
						*/
      	      			Student studentObj= courseSchedulerObj.allocateCourses(courseInfoList,myfile.nextLine());
      	      			studentAllocatedCourseList.add(studentObj);
      				}
	  				}
			}
			
			return studentAllocatedCourseList;

          // catch block to hadle the error
          }catch(FileNotFoundException e){
			e.printStackTrace();
          }catch(Exception e){
			e.printStackTrace();
          }
		   finally{
			
		  } 
		  return studentAllocatedCourseList;  		  				
		
	}
	
    
}
