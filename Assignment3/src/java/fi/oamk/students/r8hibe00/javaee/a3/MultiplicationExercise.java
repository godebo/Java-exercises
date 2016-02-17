/*
    A helper class that generates a random pair of integers
 */

package fi.oamk.students.r8hibe00.javaee.a3;

import java.util.Random;

/**
 *
 * @author Bereket Godebo
 */
public class MultiplicationExercise {
    
    private final int firstOperand;
    private final int secondOperand;
    private int userAnswer;
    
    
    public MultiplicationExercise() {
        firstOperand = new Random().nextInt(9) + 1;
        secondOperand = new Random().nextInt(9) + 1;
        userAnswer = 0;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int operation() {
        return firstOperand * secondOperand;
    }

    public String display() {
        return (firstOperand + " X " + secondOperand);
    }
    
    /**
     * 
     * @return
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
        final MultiplicationExercise other = (MultiplicationExercise) obj;
        return firstOperand == other.firstOperand && secondOperand == other.secondOperand;
    }
}
