package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "USER")
public class UserEntity {
    private int id;
    private String username;
    private String surname;
    private String email;
    private Timestamp lastcompletetestdate;
    private Timestamp lastincompletetestdate;
    private Collection<TestreviewhistoryEntity> testreviewhistoriesById;

    public UserEntity(int id, String username, String surname, String email, Timestamp lastcompletetestdate, Timestamp lastincompletetestdate, Collection<TestreviewhistoryEntity> testreviewhistoriesById) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.lastcompletetestdate = lastcompletetestdate;
        this.lastincompletetestdate = lastincompletetestdate;
        this.testreviewhistoriesById = testreviewhistoriesById;
    }

    public UserEntity(int id, String username, String surname, String email, Timestamp lastcompletetestdate, Timestamp lastincompletetestdate) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.lastcompletetestdate = lastcompletetestdate;
        this.lastincompletetestdate = lastincompletetestdate;
    }

    public UserEntity() {
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
    @Column(name = "USERNAME", nullable = false, length = 25)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "SURNAME", nullable = false, length = 25)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "LASTCOMPLETETESTDATE", nullable = false)
    public Timestamp getLastcompletetestdate() {
        return lastcompletetestdate;
    }

    public void setLastcompletetestdate(Timestamp lastcompletetestdate) {
        this.lastcompletetestdate = lastcompletetestdate;
    }

    @Basic
    @Column(name = "LASTINCOMPLETETESTDATE", nullable = false)
    public Timestamp getLastincompletetestdate() {
        return lastincompletetestdate;
    }

    public void setLastincompletetestdate(Timestamp lastincompletetestdate) {
        this.lastincompletetestdate = lastincompletetestdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (lastcompletetestdate != null ? !lastcompletetestdate.equals(that.lastcompletetestdate) : that.lastcompletetestdate != null)
            return false;
        if (lastincompletetestdate != null ? !lastincompletetestdate.equals(that.lastincompletetestdate) : that.lastincompletetestdate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lastcompletetestdate != null ? lastcompletetestdate.hashCode() : 0);
        result = 31 * result + (lastincompletetestdate != null ? lastincompletetestdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserid")
    public Collection<TestreviewhistoryEntity> getTestreviewhistoriesById() {
        return testreviewhistoriesById;
    }

    public void setTestreviewhistoriesById(Collection<TestreviewhistoryEntity> testreviewhistoriesById) {
        this.testreviewhistoriesById = testreviewhistoriesById;
    }
}
