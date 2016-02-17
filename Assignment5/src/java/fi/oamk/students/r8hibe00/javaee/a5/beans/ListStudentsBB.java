/*
    
 */
package fi.oamk.students.r8hibe00.javaee.a5.beans;

import fi.oamk.students.r8hibe00.javaee.a5.entity.Exam;
import fi.oamk.students.r8hibe00.javaee.a5.entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ListStudentsBB implements Serializable{
    private Exam exam;
    
    @Inject
    Conversation conversation;
    
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
     * @return list of students signed-up
     */
    public List<Student> getStudents() {
        return exam.getSignups();
    }
    /**
     * 
     * @return 
     */
    public String back() {
        conversation.end();
        return "teacherPage?faces-redirect=true";
    }
    
    

   
    
}
