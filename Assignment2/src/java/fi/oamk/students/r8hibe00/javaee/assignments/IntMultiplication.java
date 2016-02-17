/*
 ******************* By Bereket Godebo ************************
 ********************** Assignment 2 **************************
 **Helper class to create two random numbers 
 ******  for multiplication problem.
 **Provides a method to check for equality 
 *******since no two problems should be identical, 
 ***********and a method to display the problem  **************
 */
package fi.oamk.students.r8hibe00.javaee.assignments;

import java.util.Random;

/**
 * @author bereket
 */
public class IntMultiplication extends IntOperations {
  
    public IntMultiplication() {
        firstOperand = new Random().nextInt(9) + 1;
        secondOperand = new Random().nextInt(9) + 1;
    }
    
    @Override
    public int operation() {
        return firstOperand * secondOperand;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String display() {
        return (firstOperand + " X " + secondOperand);
    }
    /**
     * 
     * @return Integer
     */
    @Override
    public int hashCode() {
        return firstOperand ^ secondOperand;
    }
    /**
     * 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IntMultiplication other = (IntMultiplication) obj;
        return firstOperand == other.firstOperand && secondOperand == other.secondOperand;
    }
    
}
