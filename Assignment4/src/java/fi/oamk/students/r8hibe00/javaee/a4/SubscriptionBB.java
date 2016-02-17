/*
    A Backing Bean used in a page where students sign-up
    and remove from examinations
    The Injected Backing Bean contains a reference to the selected Exam
 */
package fi.oamk.students.r8hibe00.javaee.a4;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SubscriptionBB {
    private final Student student = new Student();
    @Inject
    private StudentSelectedExamBB examHolder;
    /**
     * 
     * @return student
     */
    public Student getStudent() {
        return student;
    }
    /**
     * 
     * @return a url to redirect
     */
    public String signUp() {
        examHolder.getExam().signUp(student);
        return "studentPage?faces-redirect=true";
    }
    /**
     * 
     * @return a url to redirect
     */
    public String remove() {
        examHolder.getExam().rmSignUp(student.getStudentID());//since studentID is used to remove
        return "studentPage?faces-redirect=true";
    }
    

    
    
}
