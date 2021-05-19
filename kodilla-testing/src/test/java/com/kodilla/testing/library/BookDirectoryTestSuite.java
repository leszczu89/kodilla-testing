package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;
    @Test
    void testListBooksWithConditionsReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title "+n, "Author "+ n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    @Test
    void testListBooksWithConditionMoreThan20() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }
    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }
        @Test
        void testListBooksInHandsOfWithNoBooks() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> booksInUsersHandsWithNoBooks = new ArrayList<>();
            LibraryUser libraryUser1 = new LibraryUser("Firstname", "Lastname", "12341234986");
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(booksInUsersHandsWithNoBooks);
            //When
            List<Book> result0Books = bookLibrary.listBooksInHandsOf(libraryUser1);
            //Then
            assertEquals(0, result0Books.size());
        }

        @Test
        void testListBooksInHandsOfWith1Book() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> booksInUsersHandsWith1Book = new ArrayList<>();
            LibraryUser libraryUser1 = new LibraryUser("Firstname2", "Lastname2", "89546123456");
            booksInUsersHandsWith1Book.add(new Book("Secrets of Alamo", "John Smith", 2008));
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(booksInUsersHandsWith1Book);
            //When
            List<Book> result1Book = bookLibrary.listBooksInHandsOf(libraryUser1);
            //Then
            assertEquals(1, result1Book.size());
        }

        @Test
        void testListBooksInHandsOfWith5Books() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> booksInUsersHandsWith5Book = generateListOfNBooks(5);
            LibraryUser libraryUser1 = new LibraryUser("Firstname4", "Lastname", "88546123458");
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(booksInUsersHandsWith5Book);
            //When
            List<Book> result1Book = bookLibrary.listBooksInHandsOf(libraryUser1);
            //Then
            assertEquals(5, result1Book.size());
        }
}
