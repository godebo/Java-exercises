/*
    
 */
package fi.oamk.students.r8hibe00.javaee.exam.beans;

import fi.oamk.students.r8hibe00.javaee.exam.entity.UserDetail;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Named
@Stateless
public class EmailCollector {
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * 
     * @return list of user email and gift choice
     */
    public List<UserDetail> getListOfEmails() {
        CriteriaQuery<UserDetail> criteriaQuerry
                = entityManager
                .getCriteriaBuilder()
                .createQuery(UserDetail.class);
        criteriaQuerry.select(criteriaQuerry.from(UserDetail.class));

        return entityManager.createQuery(criteriaQuerry).getResultList();
    }
    
    /**
     * 
     * @param userDetail
     */
    public void add(UserDetail userDetail) {
        entityManager.persist(userDetail);
    }
}
