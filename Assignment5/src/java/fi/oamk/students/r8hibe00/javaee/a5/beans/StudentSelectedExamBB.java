/*
    
 */
package fi.oamk.students.r8hibe00.javaee.a5.beans;

import fi.oamk.students.r8hibe00.javaee.a5.entity.Exam;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class StudentSelectedExamBB {

    @Inject
    Conversation conversation;
    
    @Inject
    private SubscriptionBB subscription;
    /**
     * 
     * @param exam
     * @return a url to redirect
     */
    public String selectExam(Exam exam) {
        conversation.begin();
        subscription.setExam(exam);
        return "signupAndRemovePage";
    }
    
}
