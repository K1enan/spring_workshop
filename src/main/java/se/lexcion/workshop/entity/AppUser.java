package se.lexcion.workshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {

    // add constructors, setters and getters + equal and hash code + toString method
    // map java model to database table with Entity annotation and other annotations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    public int appUserId;
    @Column(nullable = false, unique = true, length = 100)
    private String userName;
    @Column(nullable = false, length = 100)
    private String passWord;
    @Column(nullable = false)
    private LocalDate regDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private Details userDetails;

    public AppUser() {
    }

    public AppUser(String userName, String passWord, LocalDate regDate, Details userDetails) {
        this.userName = userName;
        this.passWord = passWord;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

    public AppUser(int appUserId, String userName, String passWord, LocalDate regDate, Details userDetails) {
        this.appUserId = appUserId;
        this.userName = userName;
        this.passWord = passWord;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
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
        if (passWord == null) throw new RuntimeException("Password should not be null");
        this.passWord = passWord;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId && userName.equals(appUser.userName) && passWord.equals(appUser.passWord) && regDate.equals(appUser.regDate) && userDetails.equals(appUser.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, userName, passWord, regDate, userDetails);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }


}
