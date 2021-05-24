package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userIdentityNumber;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postsNumber;

    public ForumUser(int userIdentityNumber, String userName, char sex, LocalDate dateOfBirth, int postsNumber) {
        this.userIdentityNumber = userIdentityNumber;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postsNumber = postsNumber;
    }

    public int getUserIdentityNumber() {
        return userIdentityNumber;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        if (userIdentityNumber != forumUser.userIdentityNumber) return false;
        if (sex != forumUser.sex) return false;
        if (postsNumber != forumUser.postsNumber) return false;
        if (!userName.equals(forumUser.userName)) return false;
        return dateOfBirth.equals(forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = userIdentityNumber;
        result = 31 * result + userName.hashCode();
        result = 31 * result + (int) sex;
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + postsNumber;
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userIdentityNumber=" + userIdentityNumber +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsNumber=" + postsNumber +
                '}';
    }
}
