package controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dao.TestreviewhistoryDao;
import model.TestreviewhistoryEntity;
import org.apache.log4j.Logger;


@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
    private final static Logger logger = Logger.getLogger(BasicView.class.getName());
    private List <TestreviewhistoryEntity> testreviewhistoryEntities;

    @PostConstruct
    public void init() {
        logger.info("Start of data initialization (Testreviewhistory)");
        TestreviewhistoryDao testreviewhistoryDao = new TestreviewhistoryDao();
        testreviewhistoryEntities= testreviewhistoryDao.getTestreviewhistory();
        logger.info("Finish of data initialization (Testreviewhistory)");
    }

    public List<TestreviewhistoryEntity> getTestreviewhistoryEntities() {
        return testreviewhistoryEntities;
    }

    public void setTestreviewhistoryEntities(List<TestreviewhistoryEntity> testreviewhistoryEntities) {
        this.testreviewhistoryEntities = testreviewhistoryEntities;
    }
}