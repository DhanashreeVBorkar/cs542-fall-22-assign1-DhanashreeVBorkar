package studentCoursesBackup.interfaces;

/**
 * @author Dhanashree V Borkar
 */
public interface CourseInfoInterface {
	
	public String getCourseName();
	public int getCourseCapacity();
	public int getCourseTimeslot();
	public int getCourseVacantSeats();
	
	public void setCourseName(String CourseNameIn);
	public void setCourseCapacity(int capacityIn);
	public void setCourseTimeslot(int timeslotIn);
	public void setCourseVacantSeats(int vacantSeatsIn);
	
}