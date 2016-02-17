/*
    a backing bean to collected user details
 */
package fi.oamk.students.r8hibe00.javaee.exam.beans;

import fi.oamk.students.r8hibe00.javaee.exam.entity.UserDetail;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CollectorBB {
    private final UserDetail userDetail = new UserDetail();
    
    @EJB
    private EmailCollector collectedEmail;

    /**
     * 
     * @return 
     */
    public UserDetail getUserDetail() {
        return userDetail;
    }
    /**
     * 
     * @return 
     */
    public String addUserDetail() {
        userDetail.setCollectedTime(new Date());
        collectedEmail.add(userDetail);
        return "thanks?faces-redirect=true";
    }
    
    
    
}
