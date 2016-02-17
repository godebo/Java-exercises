/*
    A Backing Bean used to list students who signed-up for 
    the selected exam.
    The Injected Backing Bean contains a reference to the selected Exam
 */
package fi.oamk.students.r8hibe00.javaee.a4;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ListStudentsBB {
    
    @Inject
    private TeacherSelectedExamBB examHolder;// contains the selected exam
    /**
     * 
     * @return list of student signed-up
     */
    public List<Student> getStudents() {
        return examHolder.getExam().getStudentList();
    }

   
    
}
