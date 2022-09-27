package studentCoursesBackup.driver;

// importing file
import java.io.File;
// importing scanner
import java.util.Scanner;

import java.util.ArrayList;
import studentCoursesBackup.models.CourseInfo;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.models.Student;


/**
 * @author Dhanashree V Borkar
 */
public class Driver {

	private static ArrayList<CourseInfo> courseInfoList ;
	private static ArrayList<Student> studentAllocatedCourseList;

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
			courseInfoList = new ArrayList<CourseInfo>();
        	studentAllocatedCourseList = new ArrayList<Student>();
            // java read file
		    for (int i = 0; i < args.length; i++) {
				//System.out.printf("args[%d]=%s\n", i, args[i]);
            // File to be scanned
			// java read file providing relative path
		File file = new File("..//studentCoursesBackup//src//"+args[i]);
      	Scanner myfile = new Scanner(file);
      	//System.out.println("The file contains the following data:");
      	// while loop to iterate
      			while (myfile.hasNextLine()){
      				//reading the data from input files
      				if(i==0) {
      					//courseInfo.txt
      					courseInfoList.add(storeCourseInfo(myfile.nextLine()));
      				}else if(i==1) {
      					//coursePrefs.txt
      	      			Student studentObj= allocateCourses(courseInfoList,myfile.nextLine());
      	      			studentAllocatedCourseList.add(studentObj);
      	      			
      				}
	  				}
			}
			//printing results after course allocation
			Results resultsObj = new Results();
		    resultsObj.printStudentCourseDecisionResult(studentAllocatedCourseList);
          // catch block to hadle the error
          }catch(Exception e){
            System.out.println("Error accurs!");
			e.printStackTrace();
          }    		  				
		
	}

	public static CourseInfo storeCourseInfo(String recordIn) {
		
		recordIn=recordIn.replace(" ","");
		
		String recordsArr[]= recordIn.split(":");
		
		CourseInfo courseInfoObj = new CourseInfo();
		
		if(recordsArr.length==3) {
			
			courseInfoObj.setCourseName(recordsArr[0]);
			courseInfoObj.setCourseCapacity(Integer.parseInt(recordsArr[1]));
			courseInfoObj.setCourseVacantSeats(Integer.parseInt(recordsArr[1]));
			courseInfoObj.setCourseTimeslot(Integer.parseInt(recordsArr[2]));
		}
		
		return courseInfoObj;
	}
	

	
	public static Student allocateCourses(ArrayList<CourseInfo> courseInfoListIn, String studCoursePrefRecord) {
		
	
		//obtained student record to process
	
		int allocatedSubCount =0;
		Student studentObj= new Student();
		
		studCoursePrefRecord = studCoursePrefRecord.replace(";", "");
		
		String recordsArr[]= studCoursePrefRecord.split(" ");
		if(recordsArr.length==10) {
			studentObj.setStudentId(Integer.parseInt(recordsArr[0]));
			for(int j=1;j<recordsArr.length;j++) {
			for(int i=0;i<courseInfoListIn.size();i++) {
				
				
					if(recordsArr[j].toString().equals(courseInfoListIn.get(i).getCourseName())) {
						if(courseInfoListIn.get(i).getCourseVacantSeats()>0) {
							if(allocatedSubCount==0) {
								//allocate first sub
								studentObj.setFirstCourse(""+recordsArr[j]);
								studentObj.setFirstCourseScore(9-(j-1));
								studentObj.setFirstCourseTime(courseInfoListIn.get(i).getCourseTimeslot());
								
							}else if(allocatedSubCount==1 && courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getFirstCourseTime() ) {
								//allocate second sub
								studentObj.setSecondCourse(recordsArr[j]);
								studentObj.setSecondCourseScore(9-(j-1));
								studentObj.setSecondCourseTime(courseInfoListIn.get(i).getCourseTimeslot());

							}else if(allocatedSubCount ==2 && courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getFirstCourseTime() && courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getSecondCourseTime()) {
								//allocate third sub
								studentObj.setThirdCourse(recordsArr[j]);
								studentObj.setThirdCourseScore(9-(j-1));
								studentObj.setThirdCourseTime(courseInfoListIn.get(i).getCourseTimeslot());

							}else {
								break;
							}
							allocatedSubCount++;
							int remainingVacantSeats= courseInfoListIn.get(i).getCourseVacantSeats();
							remainingVacantSeats--;
							courseInfoListIn.get(i).setCourseVacantSeats(remainingVacantSeats);

						}else {
							System.out.print("no vancant seats to allocate course");
						}
					}
				}
				
			}
			studentObj.setSatisfactionRating(calculateSatisfactionRating(studentObj));
			
		}
		return studentObj;
					
	}

	private static double calculateSatisfactionRating(Student studentObjIn) {
		
		double satisfactionRating= Double.parseDouble(""+(studentObjIn.getFirstCourseScore()+studentObjIn.getSecondCourseScore()+studentObjIn.getThirdCourseScore()))/3.0;
		
		return satisfactionRating;
		
	}

}
