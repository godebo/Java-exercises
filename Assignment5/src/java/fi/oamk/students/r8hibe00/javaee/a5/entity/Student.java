/*
    A student Entity 
 */
package fi.oamk.students.r8hibe00.javaee.a5.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student implements Serializable {
    
    @Id
    private String studentID;
    private String studentGroup;
    private String lastName;
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "COURSECODE")
    private Exam exam;

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
     * @return 
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * 
     * @param studentID 
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * 
     * @return 
     */
    public String getStudentGroup() {
        return studentGroup;
    }

    /**
     * 
     * @param studentGroup 
     */
    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    /**
     * 
     * @return 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode(): 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return Objects.equals(this.studentID, other.studentID);
    }
}
