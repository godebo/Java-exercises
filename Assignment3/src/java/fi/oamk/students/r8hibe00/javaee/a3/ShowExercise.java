/*
    
 */
package fi.oamk.students.r8hibe00.javaee.a3;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class ShowExercise {
    
    @Inject
    private ApplicationStage exercise;
    

    /**
     * 
     * @return Exercise to display
     */
    public String displayExercise() {
        return exercise.getCurrentExercise().display();
    }
    
    /**
     * 
     * @return Summary of problems, user answer and a comment
     */
    public List<MultiplicationExercise> getSummary() {
        return exercise.getExercises();
    }
    
}
