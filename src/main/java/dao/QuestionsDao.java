package dao;

import model.QuestionsEntity;
import model.UserEntity;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class QuestionsDao {
    private final static Logger logger = Logger.getLogger(QuestionsDao.class.getName());

    private final EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    @SuppressWarnings("unchecked")
    public List<QuestionsEntity> getQuestions (){
        long start = System.currentTimeMillis();
        List resultList = entityManager.createQuery("select question from QuestionsEntity question").getResultList();
        logger.info ("getQuestions Query lasted for " + (System.currentTimeMillis() - start));
        return resultList;
    }

    public void saveQuestions(QuestionsEntity us) {
        long start = System.currentTimeMillis();
        entityManager.getTransaction().begin();
        entityManager.persist(us);
        entityManager.getTransaction().commit();
        logger.info ("saving question lasted for " + (System.currentTimeMillis() - start));
    }
}
