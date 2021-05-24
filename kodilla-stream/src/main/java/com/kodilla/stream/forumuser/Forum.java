package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        ForumUser user1 = new ForumUser(1001, "User1", 'M', LocalDate.of(1990, 10, 10), 3);
        ForumUser user2 = new ForumUser(1002, "User2", 'F', LocalDate.of(2000, 12, 5), 1);
        ForumUser user3 = new ForumUser(1003, "User3", 'M', LocalDate.of(1978, 6, 1), 20);
        ForumUser user4 = new ForumUser(1004, "User4", 'M', LocalDate.of(1998, 1, 30), 0);
        ForumUser user5 = new ForumUser(1005, "User5", 'F', LocalDate.of(2005, 9, 22), 10);
        ForumUser user6 = new ForumUser(1006, "User6", 'M', LocalDate.of(2008, 7, 16), 4);
        ForumUser user7 = new ForumUser(1007, "User7", 'M', LocalDate.of(2001, 5, 16), 2);
        ForumUser user8 = new ForumUser(1008, "User8", 'M', LocalDate.of(2001, 6, 2), 10);
        forumUserList.add(user1);
        forumUserList.add(user2);
        forumUserList.add(user3);
        forumUserList.add(user4);
        forumUserList.add(user5);
        forumUserList.add(user6);
        forumUserList.add(user7);
        forumUserList.add(user8);
    }
    public List<ForumUser> getUserList() {
            return new ArrayList<>(forumUserList);
    }

}
