/*
    an entity class for representing user details
 */
package fi.oamk.students.r8hibe00.javaee.exam.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserDetail implements Serializable {
    
    @Id 
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectedTime;
    private String emailAddress;
    private String giftChoice;

    public Date getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(Date collectedTime) {
        this.collectedTime = collectedTime;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGiftChoice() {
        return giftChoice;
    }

    public void setGiftChoice(String giftChoice) {
        this.giftChoice = giftChoice;
    }
    
    
}
