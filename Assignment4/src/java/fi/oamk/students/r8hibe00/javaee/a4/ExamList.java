/*
 A Named Bean to persist the list of Exam at the application level
 */
package fi.oamk.students.r8hibe00.javaee.a4;

import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ExamList {
    private final List<Exam> listOfExam = new LinkedList<>();

    /**
     * 
     * @return listOfExam
     */
    public List<Exam> getListOfExam() {
        return listOfExam;
    }
    /**
     * 
     * @param exam 
     */
    public synchronized void addExam(Exam exam) {
        listOfExam.add(exam);
    }
    /**
     * 
     * @param exam 
     */
    public synchronized void remove(Exam exam) {
        listOfExam.remove(exam);
    }
    
    
}
