/*
    A Session Scoped Named Bean to hold the reference
    for the selected exam in between requests
 */
package fi.oamk.students.r8hibe00.javaee.a4;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TeacherSelectedExamBB implements Serializable{
    private Exam exam;
    
    /**
     * 
     * @return exam
     */
    public Exam getExam() {
        return exam;
    }
    /**
     * 
     * @param exam
     * @return a url to redirect
     */
    public String selectExam(Exam exam) {
        this.exam = exam;
        return "listOfStudents?faces-redirect=true";
    }
    
    
}
