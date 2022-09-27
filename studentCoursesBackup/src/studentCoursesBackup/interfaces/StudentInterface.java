package studentCoursesBackup.interfaces;

public interface StudentInterface {
	
	
	
	public void setStudentId(int studentIDIn);
	public void setFirstCourse(String firstCourseIn);
	public void setSecondCourse(String secondCourseIn);
	public void setThirdCourse(String thirdCourseIn);
	
	public int getStudentID();
	public String getFirstCourse();
	public String getSecondCourse();
	public String getThirdCourse();
	
	public void setFirstCourseScore(int firstCourseScoreIn);
	public void setSecondCourseScore(int secondCourseScoreIn);
	public void setThirdCourseScore(int thirdCourseScoreIn);
	
	public float getFirstCourseScore();
	public float getSecondCourseScore();
	public float getThirdCourseScore();
	
	
	public double calculateAvgSatisfactionRating();
	void setSatisfactionRating(double satisfactionRatingIN);
	public double getSatisfactionRating();

}
