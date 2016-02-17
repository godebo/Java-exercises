/*
    A teacher can add a new exam to the application 
    by filling in on a "New Exam" form

    Backing Bean used to create new exam
 */
package fi.oamk.students.r8hibe00.javaee.a4;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NewExamBB {
    private final Exam exam = new Exam();

    @Inject
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
        listOfExam.addExam(exam);
        return "teacherPage?faces-redirect=true";
    }
}
