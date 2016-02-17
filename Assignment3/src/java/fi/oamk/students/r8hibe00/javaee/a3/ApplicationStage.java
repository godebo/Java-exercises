/*
    A session scoped bean for
 */

package fi.oamk.students.r8hibe00.javaee.a3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Bereket Godebo
 */

@SessionScoped
public class ApplicationStage implements Serializable {
    
    public enum Stage {
                HOME,
                EXERCISES,
                SUMMARY,
                END
    }
    private Stage appStage = Stage.HOME;
    private MultiplicationExercise currentExercise;
    private List<MultiplicationExercise> exercises;
    private int problemCounter;

    public boolean isTryAgain() {
        return tryAgain;
    }

    public List<MultiplicationExercise> getExercises() {
        return exercises;
    }

    public void setTryAgain(boolean tryAgain) {
        this.tryAgain = tryAgain;
    }
    private boolean tryAgain;

    public ApplicationStage() {
        currentExercise = new MultiplicationExercise();
        problemCounter = 1;
        tryAgain = false;
    }

    public int getCounter() {
        return problemCounter;
    }

    public MultiplicationExercise getCurrentExercise() {
        return currentExercise;
    }

    public void setCounter(int problemCounter) {
        this.problemCounter = problemCounter;
    }

    public Stage getAppStage() {
        return appStage;
    }

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }
    
    public void beginExercise() {
        appStage = Stage.EXERCISES;
        exercises = new ArrayList<>();
        currentExercise = new MultiplicationExercise();
        problemCounter = 1;
    }
    
    public void proceed(String answer) {
        currentExercise.setUserAnswer(Integer.parseInt(answer));
        exercises.add(currentExercise);
        currentExercise = new MultiplicationExercise();
        while (exercises.contains(currentExercise)) {
            currentExercise = new MultiplicationExercise();
        }
        
        if (problemCounter == 10) {
            appStage = Stage.SUMMARY;
        }
        ++problemCounter;

    }
    
    public void quitExercise() {
        appStage = Stage.HOME;
    }

}
