package model;

import javax.persistence.*;

@Entity
@Table(name = "TESTREVIEWHISTORY")
public class TestreviewhistoryEntity {
    private UserEntity userByUserid;
    private Integer id;
    private int testansweredcountquestion;
    private int testunanasweredcountquestion;

    public TestreviewhistoryEntity() {
    }

    public TestreviewhistoryEntity(UserEntity userByUserid, int id, int testansweredcountquestion, int testunanasweredcountquestion) {
        this.userByUserid = userByUserid;
        this.id = id;
        this.testansweredcountquestion = testansweredcountquestion;
        this.testunanasweredcountquestion = testunanasweredcountquestion;
    }

    public TestreviewhistoryEntity(UserEntity userByUserid, int testansweredcountquestion, int testunanasweredcountquestion) {
        this.userByUserid = userByUserid;
        this.testansweredcountquestion = testansweredcountquestion;
        this.testunanasweredcountquestion = testunanasweredcountquestion;
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "ID", nullable = false)
    public UserEntity getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(UserEntity userByUserid) {
        this.userByUserid = userByUserid;
    }



    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TESTANSWEREDCOUNTQUESTION", nullable = false)
    public int getTestansweredcountquestion() {
        return testansweredcountquestion;
    }

    public void setTestansweredcountquestion(int testansweredcountquestion) {
        this.testansweredcountquestion = testansweredcountquestion;
    }

    @Basic
    @Column(name = "TESTUNANASWEREDCOUNTQUESTION", nullable = false)
    public int getTestunanasweredcountquestion() {
        return testunanasweredcountquestion;
    }

    public void setTestunanasweredcountquestion(int testunanasweredcountquestion) {
        this.testunanasweredcountquestion = testunanasweredcountquestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestreviewhistoryEntity that = (TestreviewhistoryEntity) o;

        if (testansweredcountquestion != that.testansweredcountquestion) return false;
        if (testunanasweredcountquestion != that.testunanasweredcountquestion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + testansweredcountquestion;
        result = 31 * result + testunanasweredcountquestion;
        return result;
    }


}
