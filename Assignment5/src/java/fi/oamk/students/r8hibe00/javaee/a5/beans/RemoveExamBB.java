/*
    a teacher can also remove an exam
 */
package fi.oamk.students.r8hibe00.javaee.a5.beans;

import fi.oamk.students.r8hibe00.javaee.a5.entity.Exam;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RemoveExamBB {
    @EJB
    private ExamList listOfExam;
    
    /**
     * 
     * @param exam
     * @return url to redirect
     */
    public String remove(Exam exam) {
        listOfExam.remove(exam);
        return "teacherPage?faces-redirect=true";
    }
}
