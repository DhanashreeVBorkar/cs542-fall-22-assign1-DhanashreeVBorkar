package studentCoursesBackup.models;

import studentCoursesBackup.interfaces.CourseInfoInterface;

public class CourseInfo implements CourseInfoInterface {

	private String courseName = "";
	private int courseCapacity = 0;
	private int courseTimeslot = 0;
	private int courseVacantSaets = 0;
	
	
	
	@Override
	public String getCourseName() {
		return courseName;
	}

	@Override
	public int getCourseCapacity() {
		return courseCapacity;
	}

	@Override
	public int getCourseTimeslot() {
		return courseTimeslot;
	}

	@Override
	public int getCourseVacantSeats() {
		return courseVacantSaets;
	}

	@Override
	public void setCourseName(String CourseNameIn) {
		courseName =CourseNameIn;
	}

	@Override
	public void setCourseCapacity(int capacityIn) {
		courseCapacity=capacityIn;
		
	}

	@Override
	public void setCourseTimeslot(int timeslotIn) {
		courseTimeslot=timeslotIn;
	}

	@Override
	public void setCourseVacantSeats(int vacantSeatsIn) {
		courseVacantSaets = vacantSeatsIn;
	}

	@Override
	public String toString() {
		return "CourseInfo [courseName=" + courseName + ", courseCapacity=" + courseCapacity + ", courseTimeslot="
				+ courseTimeslot + ", courseVacantSaets=" + courseVacantSaets + "]";
	}
	
	
	
	
	

}
