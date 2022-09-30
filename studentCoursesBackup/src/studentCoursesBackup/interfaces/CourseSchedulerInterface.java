package studentCoursesBackup.interfaces;


//importing  ArrayLList as we are using this data structure for storing data
import java.util.ArrayList;

//importing supporting classes within same package
import studentCoursesBackup.models.CourseInfo;
import studentCoursesBackup.models.Student;

/**
 * @author Dhanashree V Borkar
 */
public interface CourseSchedulerInterface {

	public CourseInfo storeCourseInfo(String recordIn) ;
    public double calculateSatisfactionRating(Student studentObjIn) ;
    public Student allocateCourses(ArrayList<CourseInfo> courseInfoListIn, String studCoursePrefRecord);

}
