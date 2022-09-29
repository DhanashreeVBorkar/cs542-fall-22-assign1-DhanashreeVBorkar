package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.models.CourseInfo;
import studentCoursesBackup.models.Student;

import java.io.FileNotFoundException;


/**
 * @author Dhanashree V Borkar
 */
public class FileProcessor {
	
    public  CourseInfo storeCourseInfo(String recordIn) {
		
		recordIn=recordIn.replace(" ","");
		
		String recordsArr[]= recordIn.split(":");
		
		CourseInfo courseInfoObj = new CourseInfo();
		try{
		if(recordsArr.length==3) {
			
			courseInfoObj.setCourseName(recordsArr[0]);
			courseInfoObj.setCourseCapacity(Integer.parseInt(recordsArr[1]));
			courseInfoObj.setCourseVacantSeats(Integer.parseInt(recordsArr[1]));
			courseInfoObj.setCourseTimeslot(Integer.parseInt(recordsArr[2]));
		}
        }catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{

        }
		return courseInfoObj;
	}
	

	
	public  Student allocateCourses(ArrayList<CourseInfo> courseInfoListIn, String studCoursePrefRecord) {
		
	
		//obtained student record to process
	
		int allocatedSubCount =0;
		Student studentObj= new Student();
		String errString="";
		String conflictString="";
		
        try{
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
								
							}else if(allocatedSubCount==1  ) {
								if(courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getFirstCourseTime()){
								//allocate second sub
								studentObj.setSecondCourse(recordsArr[j]);
								studentObj.setSecondCourseScore(9-(j-1));
								studentObj.setSecondCourseTime(courseInfoListIn.get(i).getCourseTimeslot());
								}else{
									
									conflictString=""+recordsArr[j].toString()+" cousrse time is clashing with other allocated course "+studentObj.getFirstCourse();
								}

							}else if(allocatedSubCount ==2) {
								//allocate third sub
								if(courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getFirstCourseTime() && courseInfoListIn.get(i).getCourseTimeslot()!= studentObj.getSecondCourseTime()){
								studentObj.setThirdCourse(recordsArr[j]);
								studentObj.setThirdCourseScore(9-(j-1));
								studentObj.setThirdCourseTime(courseInfoListIn.get(i).getCourseTimeslot());
								}else{
									conflictString=conflictString+recordsArr[j].toString()+" cousrse time is clashing with other allocated course "+studentObj.getFirstCourse()+" or course "+studentObj.getSecondCourse();
									System.out.println("conflictString="+conflictString);
								}
							}else {
								break;
							}
							allocatedSubCount++;
							int remainingVacantSeats= courseInfoListIn.get(i).getCourseVacantSeats();
							remainingVacantSeats--;
							courseInfoListIn.get(i).setCourseVacantSeats(remainingVacantSeats);

						}else {
							errString=errString +"no vancant seats in course "+courseInfoListIn.get(i).getCourseName()+" to allocate ";
							System.out.println("errString3="+errString);
						}
					}
				}
				
			}
			studentObj.setSatisfactionRating(calculateSatisfactionRating(studentObj));
			if(errString!=""){
				studentObj.setErrMessage(""+studentObj.getStudentID()+" "+errString);
			}
			if(conflictString!=""){
				studentObj.setConflictMessage(""+studentObj.getStudentID()+" "+conflictString);
			}
			
		}
        }catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{}

		return studentObj;
					
	}

	private  double calculateSatisfactionRating(Student studentObjIn) {
        double satisfactionRating = 0d;
		try{
		satisfactionRating= Double.parseDouble(""+(studentObjIn.getFirstCourseScore()+studentObjIn.getSecondCourseScore()+studentObjIn.getThirdCourseScore()))/3.0;
        
		
        }catch(NumberFormatException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{}
        return satisfactionRating;
	}
}
