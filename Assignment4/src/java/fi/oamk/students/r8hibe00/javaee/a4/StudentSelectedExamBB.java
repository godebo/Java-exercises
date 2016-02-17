/*
    A Session scoped Named Bean used to hold the reference to
    the selected Exam in between requests
 */
package fi.oamk.students.r8hibe00.javaee.a4;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class StudentSelectedExamBB implements Serializable{
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
        return "signupAndRemovePage?faces-redirect=true";
    }
    
}
