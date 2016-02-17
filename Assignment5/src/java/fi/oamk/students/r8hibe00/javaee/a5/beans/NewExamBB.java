/*
    A teacher can add a new exam to the application 
    by filling in on a "New Exam" form

    Backing Bean used to create new exam
 */
package fi.oamk.students.r8hibe00.javaee.a5.beans;

import fi.oamk.students.r8hibe00.javaee.a5.entity.Exam;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NewExamBB {
    private final Exam exam = new Exam();

    @EJB
    private ExamList listOfExam;
    
    /**
     * 
     * @return exam
     */
    public Exam getExam() {
        return exam;
    }
    /**
     * 
     * @return url to redirect
     */
    public String addExam() {
        listOfExam.add(exam);
        return "teacherPage?faces-redirect=true";
    }
}
