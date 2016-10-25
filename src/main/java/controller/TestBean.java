package controller;

import dao.AnswersDao;
import dao.QuestionsDao;
import dao.TestreviewhistoryDao;
import dao.UserDao;
import model.AnswersEntity;
import model.QuestionsEntity;
import model.TestreviewhistoryEntity;
import model.UserEntity;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@ViewScoped
public class TestBean implements Serializable {
    private final static Logger logger = Logger.getLogger(TestBean.class.getName());

    private List<AnswersEntity> answers = new ArrayList<AnswersEntity>();
    private List<QuestionsEntity> questions = new ArrayList<QuestionsEntity>();
    private Map<QuestionsEntity, List<AnswersEntity>> questionListMap = new HashMap<QuestionsEntity, List<AnswersEntity>>();
    private List<UserEntity> users = new ArrayList<UserEntity>();
    private UserDao userDao = new UserDao();
    private TestreviewhistoryDao testreviewhistoryDao = new TestreviewhistoryDao();
    private List<QuestionsEntity> questionsForTest = new ArrayList<QuestionsEntity>();


    @PostConstruct
    public void initData() {
        logger.info("Start of data initialization (answers and questions)");
        AnswersDao answersDao = new AnswersDao();
        answers = answersDao.getAnswers();
        QuestionsDao questionsDao = new QuestionsDao();
        questions = questionsDao.getQuestions();
        logger.info("Finish of data initialization (answers and questions). Start of creating questionListMap Map for test");
        Collections.shuffle(questions);
        questionsForTest = questions.subList(0, 15);
        for (QuestionsEntity question : questionsForTest) {
            List<AnswersEntity> answersForOneQuestion = new ArrayList<AnswersEntity>();
            int questionId = question.getId();
            if (questionId == (answers.size() - 1)) {
                answersForOneQuestion.add(answers.get(questionId - 1));
                answersForOneQuestion.add(answers.get(questionId));
                answersForOneQuestion.add(answers.get(0));
            } else if (questionId == (questions.size())) {
                answersForOneQuestion.add(answers.get(questionId - 1));
                answersForOneQuestion.add(answers.get(0));
                answersForOneQuestion.add(answers.get(1));
            } else {
                answersForOneQuestion.add(answers.get(questionId - 1));
                answersForOneQuestion.add(answers.get(questionId));
                answersForOneQuestion.add(answers.get(questionId + 1));
            }
            Collections.shuffle(answersForOneQuestion);
            questionListMap.put(question, answersForOneQuestion);
        }
        logger.info("Finish of creating questionListMap for test");

    }

    public List<QuestionsEntity> getQuestionsForTest() {
        return questionsForTest;
    }

    public void setQuestionsForTest(List<QuestionsEntity> questionsForTest) {
        this.questionsForTest = questionsForTest;
    }

    public List<QuestionsEntity> getQuestions() {
        return questions;
    }

    public Map<QuestionsEntity, List<AnswersEntity>> getQuestionListMap() {
        return questionListMap;
    }

    public List<AnswersEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersEntity> answers) {
        this.answers = answers;
    }

    public AnswersEntity getAnswer(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("no id provided");
        }
        for (AnswersEntity answer : answers) {
            if (id.equals(answer.getId())) {
                return answer;
            }
        }
        return null;
    }

    public void getTestResult() {
        logger.info("Start of creating test result");
        users = userDao.getUsers();
        int good = 0;
        int bad = 0;
        for (QuestionsEntity questionsEntity : questionsForTest) {
            if (questionsEntity.getId() == questionsEntity.getUserAnswer().getId()) {
                good++;
            } else {
                bad++;
            }
        }
        logger.info("Finish of creating test result");
        testreviewhistoryDao.saveTestreviewhistory(new TestreviewhistoryEntity(users.get(0), good, bad));
        logger.info("Saving of test result");
    }

}
