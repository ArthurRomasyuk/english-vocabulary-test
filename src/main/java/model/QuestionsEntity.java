package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "QUESTIONS")
public class QuestionsEntity {
    private int id;
    private String iscommonquestion;
    private String ismultiple;
    private String isactive;
    private int level;
    private String questiondescription;
//у тебя здесь нет нормально реализованной коллекции для ответов
    private AnswersEntity answersesById;
    private AnswersEntity userAnswer;

    @Transient
    public AnswersEntity getUserAnswer() {
        return userAnswer;
    }
    public void setUserAnswer(AnswersEntity userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ISCOMMONQUESTION", nullable = false, length = 25)
    public String getIscommonquestion() {
        return iscommonquestion;
    }

    public void setIscommonquestion(String iscommonquestion) {
        this.iscommonquestion = iscommonquestion;
    }

    @Basic
    @Column(name = "ISMULTIPLE", nullable = false, length = 25)
    public String getIsmultiple() {
        return ismultiple;
    }

    public void setIsmultiple(String ismultiple) {
        this.ismultiple = ismultiple;
    }

    @Basic
    @Column(name = "ISACTIVE", nullable = false, length = 25)
    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    @Basic
    @Column(name = "LEVEL", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "QUESTIONDESCRIPTION", nullable = false, length = 255)
    public String getQuestiondescription() {
        return questiondescription;
    }

    public void setQuestiondescription(String questiondescription) {
        this.questiondescription = questiondescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsEntity that = (QuestionsEntity) o;

        return questiondescription != null ? questiondescription.equals(that.questiondescription) : that.questiondescription == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (iscommonquestion != null ? iscommonquestion.hashCode() : 0);
        result = 31 * result + (ismultiple != null ? ismultiple.hashCode() : 0);
        result = 31 * result + (isactive != null ? isactive.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (questiondescription != null ? questiondescription.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "questionsByQuestionid")
    public AnswersEntity getAnswersesById() {
        return answersesById;
    }

    public void setAnswersesById(AnswersEntity answersesById) {
        this.answersesById = answersesById;
    }
}
