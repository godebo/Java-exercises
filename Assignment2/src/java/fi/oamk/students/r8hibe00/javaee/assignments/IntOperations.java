/*
 ************** By Bereket Godebo *********************
 ************* Assignment 2 **************************
 **for future extensions like 
 ******addition, subtraction or divisio operations ***
 * 
 */
package fi.oamk.students.r8hibe00.javaee.assignments;

/**
 *
 * @author bereket
 */
public abstract class IntOperations {
   protected int firstOperand;
   protected int secondOperand;
   
   /**
    * defines operation to be applied
    * @return Integer
    */
   public abstract int operation();
   /**
    * displays the string representation for the operation
    * example "3 X 4"
    * @return String
    */
   public abstract String display();
}
