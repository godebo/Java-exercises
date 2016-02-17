/*
    
 */
package fi.oamk.students.r8hibe00.javaee.a5.beans;

import fi.oamk.students.r8hibe00.javaee.a5.entity.Exam;
import fi.oamk.students.r8hibe00.javaee.a5.entity.Student;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class SubscriptionBB implements Serializable{
    private final Student student = new Student();
    private Exam exam;
    
    @Inject
    Conversation conversation;
    
    
    @EJB
    private ExamList listOfExam;

    /**
     * 
     * @return 
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * 
     * @param exam 
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }
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
        //Linking both ways and then persisting
        student.setExam(exam);
        exam.getSignups().add(student);
        listOfExam.add(student);
        conversation.end();
        return "studentPage?faces-redirect=true";
    }
    /**
     * 
     * @return a url to redirect
     */
    public String remove() {
        listOfExam.remove(student.getStudentID());// since only the studentID is set
        conversation.end();
        return "studentPage?faces-redirect=true";
    }
    

    
    
}
