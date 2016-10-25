package dao;

import model.TestreviewhistoryEntity;
import model.UserEntity;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class TestreviewhistoryDao {
    private final static Logger logger = Logger.getLogger(TestreviewhistoryDao.class.getName());

    private final EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    @SuppressWarnings("unchecked")
    public List<TestreviewhistoryEntity> getTestreviewhistory (){
        long start = System.currentTimeMillis();
        List resultList = entityManager.createQuery("select testreviewhistory from TestreviewhistoryEntity testreviewhistory").getResultList();
        logger.info ("getTestreviewhistory Query lasted for " + (System.currentTimeMillis() - start));
        return resultList;
    }

    public void saveTestreviewhistory(TestreviewhistoryEntity us) {
        long start = System.currentTimeMillis();
        entityManager.getTransaction().begin();
        entityManager.merge(us);
        entityManager.getTransaction().commit();
        logger.info ("saving test history lasted for " + (System.currentTimeMillis() - start));
    }

}
