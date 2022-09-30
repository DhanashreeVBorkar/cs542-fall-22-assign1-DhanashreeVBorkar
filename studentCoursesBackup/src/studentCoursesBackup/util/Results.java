package studentCoursesBackup.util;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.text.DecimalFormat;

import java.util.ArrayList;

//importing supporting classes within same package
import studentCoursesBackup.interfaces.FileDisplayInterface;
import studentCoursesBackup.models.Student;

/**
 * @author Dhanashree V Borkar
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	/**
	* printStudentCourseDecisionResult method is used for
	*  printing CourseDecision in registration_results.txt
    * @param studListIn (which is ArrayList<Student>)
    * @return void
	*/
	@Override
	public void printStudentCourseDecisionResult(ArrayList<Student> studListIn) {
		// TODO Auto-generated method stub
		
		try {
			FileWriter writer = new FileWriter(new File("..//studentCoursesBackup//src//registration_results.txt"), false);
			
			double avgSatisfactionRating=0;
			DecimalFormat frmt = new DecimalFormat();
			frmt.setMaximumFractionDigits(2);
			for(int i=0;i<studListIn.size();i++) {
				String finalResult=""+studListIn.get(i).getStudentID();
				if(studListIn.get(i).getFirstCourse()!="") {
					finalResult=finalResult+":"+studListIn.get(i).getFirstCourse();
				}
				if(studListIn.get(i).getSecondCourse()!="") {
					finalResult=finalResult+", "+studListIn.get(i).getSecondCourse();
				}
				if(studListIn.get(i).getThirdCourse()!=""){
					finalResult=finalResult+", "+studListIn.get(i).getThirdCourse();
				}
				avgSatisfactionRating=avgSatisfactionRating+studListIn.get(i).getSatisfactionRating();
				finalResult = finalResult+"::SatisfactionRating= "+frmt.format(studListIn.get(i).getSatisfactionRating());
				 writer.write(finalResult+"\n");
			}
           
            avgSatisfactionRating=avgSatisfactionRating/studListIn.size();
            writer.write("AverageSatisfactionRating= "+frmt.format(avgSatisfactionRating));
            writer.close();
        }// handling exceptions
        catch(FileNotFoundException fne){
			fne.printStackTrace();
		}catch (IOException ioe) {
            ioe.printStackTrace();
        }
		catch (NumberFormatException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{

		}
		
	}


/**
	* printStudentErrResults method is used for printing 
	* errors in errors.txt
    * @param studListIn (which is ArrayList<Student>)
    * @return void
	*/
	@Override
	public void printStudentErrResults(ArrayList<Student> studListIn){
		
		try {
			FileWriter writer = new FileWriter(new File("..//studentCoursesBackup//src//errors.txt"), false);
			
			for(int i=0;i<studListIn.size();i++) {
				String errMsg=studListIn.get(i).getErrMessage();
				if(errMsg!=""){
					writer.write(errMsg+"\n");
				}
				 
			}
            writer.close();
        }// handling exceptions
        catch(FileNotFoundException fne){
			fne.printStackTrace();
		}catch (IOException ioe) {
            ioe.printStackTrace();
        }catch (Exception e) {
			e.printStackTrace();
		}
	}


/**
	* printStudentConflictResults method is used for printing 
	* conflicts in conflicts.txt
    * @param studListIn (which is ArrayList<Student>)
    * @return void
	*/
	@Override
	public void printStudentConflictResults(ArrayList<Student> studListIn){
		
		try {
			FileWriter writer = new FileWriter(new File("..//studentCoursesBackup//src//conflicts.txt"), false);
			
			
			for(int i=0;i<studListIn.size();i++) {
				String errMsg=studListIn.get(i).getConflictMessage();
				if(errMsg!=""){
					writer.write(errMsg+"\n");
				}
				 
			}
            writer.close();
        }
		// handling exceptions
        catch(FileNotFoundException fne){
			fne.printStackTrace();
		}catch (IOException ioe) {
            ioe.printStackTrace();
        }catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
