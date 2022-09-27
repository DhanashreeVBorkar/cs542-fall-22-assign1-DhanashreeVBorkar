package studentCoursesBackup.models;

import studentCoursesBackup.interfaces.StudentInterface;

public class Student implements StudentInterface {

	public int studentID= 0;
	public String firstCourse = "";
	public String secondCourse = "";
	public String thirdCourse = "";
	double satisfactionRating = 0f;
	
	public float firstCourseScore =0;
	public float secondCourseScore =0;
	public float thirdCourseScore =0;
	
	public int firstCourseTime =0;
	public int secondCourseTime =0;
	public int thirdCourseTime =0;
	
	
	
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
	public String toString() {
		return "Student [studentID=" + studentID + ", firstCourse=" + firstCourse + ", secondCourse=" + secondCourse
				+ ", thirdCourse=" + thirdCourse + ", satisfactionRating=" + satisfactionRating + ", firstCourseScore="
				+ firstCourseScore + ", secondCourseScore=" + secondCourseScore + ", thirdCourseScore="
				+ thirdCourseScore + ", firstCourseTime=" + firstCourseTime + ", secondCourseTime=" + secondCourseTime
				+ ", thirdCourseTime=" + thirdCourseTime + "]";
	}
	
	

	
	
}
