package studentCoursesBackup.util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import studentCoursesBackup.models.Student;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
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
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
	

}
