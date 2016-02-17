/*
    A Request scoped Bean used for checking inputs
    Since every request have different states(e.g wrong input, wrong answer); the bean should reset 
    after every request
 */
package fi.oamk.students.r8hibe00.javaee.a3;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InputValidator {
    private boolean wrongInput;
    private boolean wrongAnswer;
    private boolean rightAnswer;
    
    public InputValidator() {
        wrongInput = false;
        wrongAnswer = false;
        rightAnswer = false;
    }
    
    public boolean isWrongInput() {
        return wrongInput;
    }

    public void setWrongInput(boolean wrongInput) {
        this.wrongInput = wrongInput;
    }

    public boolean isWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(boolean wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
    
    
}
