package dao;

import model.AnswersEntity;
import model.QuestionsEntity;
import org.apache.log4j.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnswersDao {
    private final static Logger logger = Logger.getLogger(AnswersDao.class.getName());

    private final EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    @SuppressWarnings("unchecked")
    public List <AnswersEntity> getAnswers (){
        long start = System.currentTimeMillis();
        List resultList = entityManager.createQuery("select answer from AnswersEntity answer").getResultList();
        logger.info ("getAnswer Query lasted for " + (System.currentTimeMillis() - start));
        return resultList;
    }

    public void saveAnswers (AnswersEntity us) {
        long start = System.currentTimeMillis();
        entityManager.getTransaction().begin();
        entityManager.merge(us);
        entityManager.getTransaction().commit();
        logger.info ("saving answer lasted for " + (System.currentTimeMillis() - start));
    }
}
