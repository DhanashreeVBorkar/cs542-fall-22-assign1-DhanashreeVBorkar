package studentCoursesBackup.util;

//importing interface 
import studentCoursesBackup.interfaces.CourseSchedulerInterface;

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
public class CourseScheduler implements CourseSchedulerInterface{

/**
	* storeCourseInfo method is used for reading input from courseInfo.txt file and 
    * store values in courseInfo object and returns it to FileProcessor
    * @param recordIn
    * @return CourseInfo object
	*/
@Override
public CourseInfo storeCourseInfo(String recordIn) {
		
		recordIn=recordIn.replace(" ","");
		
		String recordsArr[]= recordIn.split(":");
		
        // allocating memory to CourseInfo Object to store course details provided in input file
		CourseInfo courseInfoObj = new CourseInfo();
		try{

        //Checks if record array length is 3 
		if(recordsArr.length==3) {
			
			courseInfoObj.setCourseName(recordsArr[0]);
			courseInfoObj.setCourseCapacity(Integer.parseInt(recordsArr[1]));
			courseInfoObj.setCourseVacantSeats(Integer.parseInt(recordsArr[1]));
			courseInfoObj.setCourseTimeslot(Integer.parseInt(recordsArr[2]));
		}else{
            // otherwise throwing error and exiting
            System.out.println("Please input valid courseInfo");
            System.exit(0);
        }
        //Handling exceptions
        }catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{

        }
		return courseInfoObj;
	}
	

/**
	* allocateCourses method is used for allocating courses to Students by taking
    * their input from fileprocessor and store the result in Student object and return
    * @param courseInfoListIn , studCoursePrefRecord
    * @return Student object
	*/
	@Override
	public Student allocateCourses(ArrayList<CourseInfo> courseInfoListIn, String studCoursePrefRecord) {
		
	
		//obtained student record to process
	
        // maintaining counter to keep track of allocated courses per student
		int allocatedSubCount =0;

		Student studentObj= new Student();
		String errString="";
		String conflictString="";
		
        try{
		studCoursePrefRecord = studCoursePrefRecord.replace(";", "");
		
		String recordsArr[]= studCoursePrefRecord.split(" ");
        //validating input from length of input
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
								
							}else if(allocatedSubCount==1  ) {
								if(courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getFirstCourseTime()){
								//allocate second sub
								studentObj.setSecondCourse(recordsArr[j]);
								studentObj.setSecondCourseScore(9-(j-1));
								studentObj.setSecondCourseTime(courseInfoListIn.get(i).getCourseTimeslot());
								}else{
									// preferred course time is conflicting with previously allocated course, so adding conflict message
									conflictString=""+recordsArr[j].toString()+" cousrse time is clashing with other allocated course "+studentObj.getFirstCourse();
								}

							}else if(allocatedSubCount ==2) {
								//allocate third sub
								if(courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getFirstCourseTime() && courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getSecondCourseTime()){
								studentObj.setThirdCourse(recordsArr[j]);
								studentObj.setThirdCourseScore(9-(j-1));
								studentObj.setThirdCourseTime(courseInfoListIn.get(i).getCourseTimeslot());
								}else{
                                    // preferred course time is conflicting with previously allocated course, so adding conflict message
									conflictString=conflictString+recordsArr[j].toString()+" cousrse time is clashing with other allocated course "+studentObj.getFirstCourse()+" or course "+studentObj.getSecondCourse();
								}
							}else {
								break;
							}
                            //updating allocated course counter
							allocatedSubCount++;
							int remainingVacantSeats= courseInfoListIn.get(i).getCourseVacantSeats();
							remainingVacantSeats--;
                            // updating total vacant seats for perticular course
							courseInfoListIn.get(i).setCourseVacantSeats(remainingVacantSeats);

						}else {
                            // preferred course capacity is over i.e. no vancant seats for course, so adding err message
							errString=errString +"no vancant seats in course "+courseInfoListIn.get(i).getCourseName()+" to allocate ";
						}
					}
				}
				
			}
            //calculating satisfaction rating for each student
			studentObj.setSatisfactionRating(calculateSatisfactionRating(studentObj));
			if(errString!=""){
				studentObj.setErrMessage(""+studentObj.getStudentID()+" "+errString);
			}
			if(conflictString!=""){
				studentObj.setConflictMessage(""+studentObj.getStudentID()+" "+conflictString);
			}
			
		}else{
            //throwing error on getting invalid input and exiting
            System.out.println("Please input valid Student preferences, Found invalid entry in coursePrefs.txt");
            System.exit(0);
        }
        //handling exceptions
        }catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{}

		return studentObj;
					
	}

/**
	* calculateSatisfactionRating method is used for calculating individual student satisfaction rating 
    * and return its result in double
    * @param studentObjIn
    * @return double
	*/
    @Override
	public double calculateSatisfactionRating(Student studentObjIn) {
        double satisfactionRating = 0d;
		try{
        // calculating satisfaction rating for each students assigned courses by considering their course preference number
		satisfactionRating= Double.parseDouble(""+(studentObjIn.getFirstCourseScore()+studentObjIn.getSecondCourseScore()+studentObjIn.getThirdCourseScore()))/3.0;
        
		
        }catch(NumberFormatException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{}
        return satisfactionRating;
	}
}