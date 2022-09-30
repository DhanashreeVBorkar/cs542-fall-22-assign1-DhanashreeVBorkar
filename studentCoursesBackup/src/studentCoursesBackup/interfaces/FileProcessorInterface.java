package studentCoursesBackup.interfaces;


import java.util.ArrayList;

//importing supporting classes within same package
import studentCoursesBackup.models.Student;

/**
 * @author Dhanashree V Borkar
 */
public interface FileProcessorInterface {

    public ArrayList<Student> readInputFromFileAndProcess(String [] args);

}