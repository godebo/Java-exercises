/*
    is used to set the exam entity for a backing bean
    used in displaying list of students in a teacher page
 */
package fi.oamk.students.r8hibe00.javaee.a5.beans;

import fi.oamk.students.r8hibe00.javaee.a5.entity.Exam;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class TeacherSelectedExamBB {
    
    @Inject
    private ListStudentsBB listStudents;
    
    @Inject
    Conversation conversation;
    
   
    /**
     * 
     * @param exam
     * @return a url to redirect
     */
    public String selectExam(Exam exam) {
        conversation.begin();
        listStudents.setExam(exam);
        return "listOfStudents";
    }
    
    
}
