/*
    On the sign-up from the student enters her 
    student ID, 
    group, 
    last name and 
    first name
 */
package fi.oamk.students.r8hibe00.javaee.a4;

public class Student {
    
    private String studentID;
    private String studentGroup;
    private String lastName;
    private String firstName;
    
    /**
     * 
     * @return studentID
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
     * @return studentGroup
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
     * @return lastName
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
     * @return firstName
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
    
    
}
