package com.emervel.domain;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by guopm on 20/06/2017.
 */
@Entity
@Data
public class User {

    @Id    @GeneratedValue
    private Long id;


    String first;
    String last;
    String mail;
    Date date;
    Boolean active;

    private User(){}

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (first != null ? !first.equals(user.first) : user.first != null) return false;
        if (last != null ? !last.equals(user.last) : user.last != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (date != null ? !date.equals(user.date) : user.date != null) return false;
        return active != null ? active.equals(user.active) : user.active == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", mail='" + mail + '\'' +
                ", date=" + date +
                ", active=" + active +
                '}';
    }
    */
}
