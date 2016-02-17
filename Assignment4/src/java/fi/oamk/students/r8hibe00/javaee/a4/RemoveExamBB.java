/*
    a teacher can also remove an exam
 */
package fi.oamk.students.r8hibe00.javaee.a4;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RemoveExamBB {
    @Inject
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
