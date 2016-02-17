/*
    An Exam entity
 */
package fi.oamk.students.r8hibe00.javaee.a5.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exam implements Serializable{
    
    @Id
    private String courseCode;
    private String courseName;
    private String examName;
    private String examDate;
    private String examTime;
    private String examPlace;

    @OneToMany(mappedBy="exam", cascade=ALL)
    private List<Student> signups;

    /**
     * 
     * @return 
     */
    public List<Student> getSignups() {
        return signups;
    }

    /**
     * 
     * @param signups 
     */
    public void setSignups(List<Student> signups) {
        this.signups = signups;
    }

    /**
     * 
     * @return 
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * 
     * @param courseCode 
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * 
     * @return 
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 
     * @param courseName 
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 
     * @return 
     */
    public String getExamName() {
        return examName;
    }

    /**
     * 
     * @param examName 
     */
    public void setExamName(String examName) {
        this.examName = examName;
    }

    /**
     * 
     * @return 
     */
    public String getExamDate() {
        return examDate;
    }

    /**
     * 
     * @param examDate 
     */
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    /**
     * 
     * @return 
     */
    public String getExamTime() {
        return examTime;
    }
    /**
     * 
     * @param examTime 
     */
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    /**
     * 
     * @return 
     */
    public String getExamPlace() {
        return examPlace;
    }

    /**
     * 
     * @param examPlace 
     */
    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseCode != null ? courseCode.hashCode(): 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exam other = (Exam) obj;
        return Objects.equals(this.courseCode, other.courseCode);
    }
    
    
}
