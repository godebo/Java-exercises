/*
    Course code (for example MATH103)
    Name of the course (for example Introduction to Geometry)
    Name of the exam (for example Mid-term exam)
    Date of the exam (for example 30.11.2015)
    Time of the exam (for example 14:15)
    Place of the exam (for example M303)
    
    Contains list of students who signed-up for the exam


 */
package fi.oamk.students.r8hibe00.javaee.a4;

import java.util.LinkedList;
import java.util.List;

public class Exam {
    private String courseCode;
    private String courseName;
    private String examName;
    private String examDate;
    private String examTime;
    private String examPlace;
    
    /*a teacher can also remove an exam,
    in which case also all sign-ups to it will be deleted.*/
    private final List<Student> studentList = new LinkedList<>();
    
    /**
     * gets the course code for the exam
     * @return courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }
    /**
     * sets the course code for the exam
     * @param courseCode 
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    /**
     * gets the course name for the exam
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }
    /**
     * sets the course name for the exam
     * @param courseName 
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /**
     * gets the Name of the exam
     * @return examName 
     */
    public String getExamName() {
        return examName;
    }
    /**
     * sets the name of the exam
     * @param examName 
     */
    public void setExamName(String examName) {
        this.examName = examName;
    }
    /**
     * gets the date of the exam
     * @return examDate 
     */
    public String getExamDate() {
        return examDate;
    }
    /**
     * sets the date for the exam
     * @param examDate
     * 
     */
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }
    /**
     * get Time of the exam
     * @return examTime
     */
    public String getExamTime() {
        return examTime;
    }
    /**
     * sets the Time of the exam
     * @param examTime 
     */
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }
    /**
     * gets Place of the exam
     * @return examPlace
     */
    public String getExamPlace() {
        return examPlace;
    }
    /**
     * sets the Place of the exam
     * @param examPlace 
     */
    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }
    /**
     * gets the list of students signed-up for the given exam
     * @return studentList
     */
    public List<Student> getStudentList() {
        return studentList;
    }
    /**
     * a new student is added to the list of students
     * @param newStudent 
     */
    public synchronized void signUp(Student newStudent) {
        studentList.add(newStudent);
    }
    /**
     * removes the student as determined by the student ID
     * @param studentID 
     */
    public synchronized void rmSignUp(String studentID) {
        if(findStudent(studentID) != null) studentList.remove((findStudent(studentID)));
    }
    
    /**
     * used for searching for Student object reference given the student ID 
     * @param studentID
     * @return searchedStudent
     */
    private Student findStudent(String studentID) {
        Student searchedStudent = null;
        for(Student s: studentList) {
            if(s.getStudentID().equals(studentID)) searchedStudent = s;
        }
        return searchedStudent;
    }
    
    
}
