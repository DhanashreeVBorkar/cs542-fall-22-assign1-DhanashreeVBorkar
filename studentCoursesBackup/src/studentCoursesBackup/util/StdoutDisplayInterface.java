package studentCoursesBackup.util;

import java.util.ArrayList;
import studentCoursesBackup.models.Student;

/**
 * @author Dhanashree V Borkar
 */
public interface StdoutDisplayInterface {

	public void printStudentCourseDecisionResult(ArrayList<Student> studListIn);

	public void printStudentErrResults(ArrayList<Student> studListIn);

	public void printStudentConflictResults(ArrayList<Student> studListIn);



}
