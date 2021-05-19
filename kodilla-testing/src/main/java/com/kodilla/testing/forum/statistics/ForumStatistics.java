package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    int usersNumber;
    int postsNumber;
    int commentsNumber;
    double averagePostsNumberPerUser;
    double averageCommentsNumberPerUser;
    double averageCommentsNumberPerPost;

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
        System.out.println("Number of users: "+ usersNumber+
                "/nNumber of posts: "+ postsNumber+
                "/nNumber of comments: " +commentsNumber+
                "/nAverage posts number per user: "+ averagePostsNumberPerUser+
                "/nAverage comments number per user: "+ averageCommentsNumberPerUser+
                "/nAverage comments number per post: "+ averageCommentsNumberPerPost);
    }
}
