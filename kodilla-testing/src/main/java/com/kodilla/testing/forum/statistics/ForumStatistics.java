package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    private double averagePostsNumberPerUser;
    private double averageCommentsNumberPerUser;
    private double averageCommentsNumberPerPost;

    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public double getAveragePostsNumberPerUser() {
        return averagePostsNumberPerUser;
    }

    public double getAverageCommentsNumberPerUser() {
        return averageCommentsNumberPerUser;
    }

    public double getAverageCommentsNumberPerPost() {
        return averageCommentsNumberPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersNumber = statistics.usersNames().size();
        postsNumber = statistics.postsCount();
        commentsNumber = statistics.commentsCount();
        if(usersNumber!=0) {
            averagePostsNumberPerUser = (double) postsNumber/usersNumber;
            averageCommentsNumberPerUser = (double) commentsNumber/usersNumber;
        } else{
            averagePostsNumberPerUser = 0;
            averageCommentsNumberPerUser = 0;
        }
        if(commentsNumber!=0){
            averageCommentsNumberPerPost = (double) commentsNumber/postsNumber;
        } else {
            averageCommentsNumberPerPost = 0;
        }

    }
    public void showStatistics() {
        System.out.println("Number of users: "+ getUsersNumber()+
                "/nNumber of posts: "+ getPostsNumber()+
                "/nNumber of comments: " +getPostsNumber()+
                "/nAverage posts number per user: "+ getAveragePostsNumberPerUser()+
                "/nAverage comments number per user: "+ getAverageCommentsNumberPerUser()+
                "/nAverage comments number per post: "+ getAverageCommentsNumberPerPost());
    }
}
