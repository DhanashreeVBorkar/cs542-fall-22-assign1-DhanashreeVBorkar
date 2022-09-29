package studentCoursesBackup.models;

import studentCoursesBackup.interfaces.StudentInterface;

/**
 * @author Dhanashree V Borkar
 */
public class Student implements StudentInterface {

	private int studentID= 0;
	private String firstCourse = "";
	private String secondCourse = "";
	private String thirdCourse = "";
	private double satisfactionRating = 0f;
	
	private float firstCourseScore =0;
	private float secondCourseScore =0;
	private float thirdCourseScore =0;
	
	private int firstCourseTime =0;
	private int secondCourseTime =0;
	private int thirdCourseTime =0;

	private String conflictMsg="";
	private String errMsg="";
	
	
	
	@Override
	public void setStudentId(int studentIDIn) {
		studentID = studentIDIn;
	}

	@Override
	public void setFirstCourse(String firstCourseIn) {
		firstCourse = firstCourseIn;		
	}

	@Override
	public void setSecondCourse(String secondCourseIn) {
		secondCourse = secondCourseIn;
		
	}

	@Override
	public void setThirdCourse(String thirdCourseIn) {
		thirdCourse= thirdCourseIn;
	}

	@Override
	public int getStudentID() {
		return studentID;
	}

	@Override
	public String getFirstCourse() {
		return firstCourse;
	}

	@Override
	public String getSecondCourse() {
		return secondCourse;
	}

	@Override
	public String getThirdCourse() {
		return thirdCourse;
	}

	

	@Override
	public double getSatisfactionRating() {
		return (firstCourseScore+secondCourseScore+thirdCourseScore)/3;
	}

	@Override
	public void setSatisfactionRating(double satisfactionRatingIN) {
		satisfactionRating = satisfactionRatingIN;
	}
	
	@Override
	public void setFirstCourseScore(int firstCourseScoreIn) {
		firstCourseScore= firstCourseScoreIn;
	}

	@Override
	public void setSecondCourseScore(int secondCourseScoreIn) {
		secondCourseScore=secondCourseScoreIn;
		
	}

	@Override
	public void setThirdCourseScore(int thirdCourseScoreIn) {
		thirdCourseScore=thirdCourseScoreIn;
		
	}

	@Override
	public float getFirstCourseScore() {
		return firstCourseScore;
	}

	@Override
	public float getSecondCourseScore() {
		return secondCourseScore;
	}

	@Override
	public float getThirdCourseScore() {
		return thirdCourseScore;
	}

	

	@Override
	public double calculateAvgSatisfactionRating() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFirstCourseTime() {
		return firstCourseTime;
	}

	public void setFirstCourseTime(int firstCourseTimeIn) {
		firstCourseTime = firstCourseTimeIn;
	}

	public int getSecondCourseTime() {
		return secondCourseTime;
	}

	public void setSecondCourseTime(int secondCourseTimeIn) {
		secondCourseTime = secondCourseTimeIn;
	}

	public int getThirdCourseTime() {
		return thirdCourseTime;
	}

	public void setThirdCourseTime(int thirdCourseTimeIn) {
		thirdCourseTime = thirdCourseTimeIn;
	}

	@Override
	public String getConflictMessage(){
		return conflictMsg;
	}

	@Override
	public void setConflictMessage(String messageIn){
	conflictMsg= messageIn;
	}

	@Override
	public String getErrMessage(){
		return errMsg;
	}

	@Override
	public void setErrMessage(String messageIn){
	errMsg= messageIn;
	}



	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", firstCourse=" + firstCourse + ", secondCourse=" + secondCourse
				+ ", thirdCourse=" + thirdCourse + ", satisfactionRating=" + satisfactionRating + ", firstCourseScore="
				+ firstCourseScore + ", secondCourseScore=" + secondCourseScore + ", thirdCourseScore="
				+ thirdCourseScore + ", firstCourseTime=" + firstCourseTime + ", secondCourseTime=" + secondCourseTime
				+ ", thirdCourseTime=" + thirdCourseTime + ", conflictMsg=" + conflictMsg + ", errMsg=" + errMsg + "]";
	}
	
	

	
	
}
