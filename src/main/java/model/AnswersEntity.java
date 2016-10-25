package model;

import javax.persistence.*;

@Entity
@Table(name = "ANSWERS")
public class AnswersEntity {
    private int id;
    private boolean iscorrect;
    private boolean isincorrect;
    private String answerdescription;
    private QuestionsEntity questionsByQuestionid;

    public AnswersEntity() {
    }


    public AnswersEntity(QuestionsEntity questionsByQuestionid, int id, boolean iscorrect, boolean isincorrect, String answerdescription) {
        this.questionsByQuestionid = questionsByQuestionid;
        this.id = id;
        this.iscorrect = iscorrect;
        this.isincorrect = isincorrect;
        this.answerdescription = answerdescription;
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
    @Column(name = "ISCORRECT", nullable = false)

    public boolean getIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(boolean iscorrect) {
        this.iscorrect = iscorrect;
    }

    public boolean getIsincorrect() {
        return isincorrect;
    }

    public void setIsincorrect(boolean isincorrect) {
        this.isincorrect = isincorrect;
    }

    @Basic
    @Column(name = "ANSWERDESCRIPTION", nullable = false, length = 255)
    public String getAnswerdescription() {
        return answerdescription;
    }

    public void setAnswerdescription(String answerdescription) {
        this.answerdescription = answerdescription;
    }

    @Override
    public String toString() {
        return "AnswersEntity{" +
                "id=" + id +
                ", iscorrect=" + iscorrect +
                ", isincorrect=" + isincorrect +
                ", answerdescription='" + answerdescription + '\'' +
                ", questionsByQuestionid=" + questionsByQuestionid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswersEntity that = (AnswersEntity) o;

        if (answerdescription != null ? !answerdescription.equals(that.answerdescription) : that.answerdescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return answerdescription != null ? answerdescription.hashCode() : 0;
    }

    @OneToOne
    @JoinColumn(name = "QUESTIONID", referencedColumnName = "ID", nullable = false)
    public QuestionsEntity getQuestionsByQuestionid() {
        return questionsByQuestionid;
    }

    public void setQuestionsByQuestionid(QuestionsEntity questionsByQuestionid) {
        this.questionsByQuestionid = questionsByQuestionid;
    }
}
