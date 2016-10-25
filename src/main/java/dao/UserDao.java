package dao;

import model.UserEntity;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class UserDao {
    private final static Logger logger = Logger.getLogger(UserDao.class.getName());

    private final EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    @SuppressWarnings("unchecked")
    public List<UserEntity> getUsers (){
        long start = System.currentTimeMillis();
        List resultList = entityManager.createQuery("select user from UserEntity user").getResultList();
        logger.info ("getUsers Query lasted for " + (System.currentTimeMillis() - start));
        return resultList;
    }
    public void saveUser(UserEntity us) {
        long start = System.currentTimeMillis();
        entityManager.getTransaction().begin();
        entityManager.merge(us);
        entityManager.getTransaction().commit();
        logger.info ("saving user lasted for " + (System.currentTimeMillis() - start));
    }

}
