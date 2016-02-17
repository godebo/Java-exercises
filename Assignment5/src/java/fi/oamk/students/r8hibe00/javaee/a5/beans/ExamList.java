/*
 
 */

package fi.oamk.students.r8hibe00.javaee.a5.beans;

import fi.oamk.students.r8hibe00.javaee.a5.entity.Exam;
import fi.oamk.students.r8hibe00.javaee.a5.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Bereket Godebo
 */
@Named
@Stateless
public class ExamList {
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * 
     * @return 
     */
    public List<Exam> getExams() {
        CriteriaQuery<Exam> criteriaQuerry
                = entityManager
                .getCriteriaBuilder()
                .createQuery(Exam.class);
        criteriaQuerry.select(criteriaQuerry.from(Exam.class));

        return entityManager.createQuery(criteriaQuerry).getResultList();
    }
    
    /**
     * 
     * @param exam 
     */
    public void add(Exam exam) {
        entityManager.persist(exam);
    }
    /**
     * 
     * @param exam 
     */
    public void remove(Exam exam) {
        entityManager.remove(
                entityManager.merge(exam)
        );
    }
    /**
     * 
     * @param student 
     */
    public void add(Student student) {
        entityManager.merge(student.getExam());
        entityManager.persist(student);
    }
     /**
      * 
      * @param studentID
      */
     public void remove(String studentID) {
         Student studentToRemove =
                 entityManager.find(Student.class, studentID);
         if(studentToRemove != null) {//removes only signed up students
              Exam signedupExam = studentToRemove.getExam();
              signedupExam.getSignups().remove(studentToRemove);// removing the link with exam
              entityManager.remove(studentToRemove);
         }
        
    }
    

}
