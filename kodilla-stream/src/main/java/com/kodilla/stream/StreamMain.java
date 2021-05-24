package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> forumUserMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex()=='M')
                .filter(forumUser -> forumUser.getPostsNumber()>=1)
                .filter(forumUser -> (Period.between(forumUser.getDateOfBirth(), LocalDate.now()).getYears() >= 20))
                .collect(Collectors.toMap(ForumUser::getUserIdentityNumber, forumUser -> forumUser));

        System.out.println("Forum users fulfilling criteria: " + forumUserMap.size());
        forumUserMap.entrySet().stream()
                .map(entry -> entry.getKey()+ " " + entry.getValue())
                .forEach(System.out::println);


    }

}
