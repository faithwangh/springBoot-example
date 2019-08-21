package com.example.springbootmybatis.model;

import java.io.Serializable;
import java.util.Objects;

public class User  implements Serializable {

    private Long id;

    private String userName;

    private String passWord;

    public User(Long id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(passWord, user.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, passWord);
    }
}
