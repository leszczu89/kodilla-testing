package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    private static int counter = 0;
    @BeforeEach
    public void before() {
        counter++;
        System.out.println("Test nr: "+counter);
    }
    @AfterEach
    public void after(){
        System.out.println("Test completed");
    }
    @Mock
    private Statistics statisticsMock;
    @Test
    void testCalculateAdvStatisticsWith0Posts(){
        //Given
        ForumStatistics forumStatisticsTest = new ForumStatistics();
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatisticsTest.calculateAdvStatistics(statisticsMock);
        int result = forumStatisticsTest.postsNumber;
        //Then
        Assertions.assertEquals(0,result);
    }
    @Test
    void testCalculateAdvStatisticsWith1000Posts(){
        //Given
        ForumStatistics forumStatisticsTest = new ForumStatistics();
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatisticsTest.calculateAdvStatistics(statisticsMock);
        int result = forumStatisticsTest.postsNumber;
        //Then
        Assertions.assertEquals(1000,result);
    }
    @Test
    void testCalculateAdvStatisticsWith0Comments(){
        //Given
        ForumStatistics forumStatisticsTest = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatisticsTest.calculateAdvStatistics(statisticsMock);
        int result = forumStatisticsTest.commentsNumber;
        //Then
        Assertions.assertEquals(0,result);
    }
    @Test
    void testCalculateAdvStatisticsWithCommentsNumberMoreThanPostsNumber(){
        //Given
        ForumStatistics forumStatisticsTest = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(10);
        //When
        forumStatisticsTest.calculateAdvStatistics(statisticsMock);
        double result = forumStatisticsTest.averageCommentsNumberPerPost;
        //Then
        Assertions.assertEquals(10,result);
    }
    @Test
    void testCalculateAdvStatisticsWithCommentsNumberLessThanPostsNumber(){
        //Given
        ForumStatistics forumStatisticsTest = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postsCount()).thenReturn(100);
        //When
        forumStatisticsTest.calculateAdvStatistics(statisticsMock);
        double result = forumStatisticsTest.averageCommentsNumberPerPost;
        //Then
        Assertions.assertEquals(0.1,result);
    }
    @Test
    void testCalculateAdvStatisticsWith0Users(){
        //Given
        ForumStatistics forumStatisticsTest = new ForumStatistics();
        List<String> usersListMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(usersListMock);
        //When
        forumStatisticsTest.calculateAdvStatistics(statisticsMock);
        int result = forumStatisticsTest.usersNumber;
        //Then
        Assertions.assertEquals(0,result);
    }
    private List<String> generateUsersList(int n){
        List<String> usersList = new ArrayList<>();
        for (int i = 1; i<= n; i++){
            usersList.add("UsersName "+i);
        }
        return usersList;
    }
    @Test
    void testCalculateAdvStatisticsWith100Users(){
        //Given
        ForumStatistics forumStatisticsTest = new ForumStatistics();
        List<String> usersListMock = generateUsersList(100);
        when(statisticsMock.usersNames()).thenReturn(usersListMock);
        //When
        forumStatisticsTest.calculateAdvStatistics(statisticsMock);
        int result = forumStatisticsTest.usersNumber;
        //Then
        Assertions.assertEquals(100,result);
    }
}
