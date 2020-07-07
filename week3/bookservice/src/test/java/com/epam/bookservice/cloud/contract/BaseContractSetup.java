package com.epam.bookservice.cloud.contract;

import static org.mockito.ArgumentMatchers.anyLong;
import com.epam.bookservice.BookserviceApplication;
import com.epam.bookservice.controller.BookController;
import com.epam.bookservice.model.Book;
import com.epam.bookservice.service.BookService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookserviceApplication.class, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMessageVerifier
public class BaseContractSetup {

    @MockBean
    private BookService service;

    @Autowired
    private BookController bookResource;

    @Before
    public void setup() {

        // setup rest end-point for the test
        RestAssuredMockMvc.standaloneSetup(bookResource);

        // mocking business layers.
        Mockito.when(service.getAllBooks()).thenReturn(getMockData1());
        Mockito.when(service.getBookById(anyLong())).thenReturn(Optional.of(getMockData2()));

    }

    private List<Book> getMockData1() {
        Book book = new Book();
        book.setId(11l);
        book.setBookName("jpop");
        book.setCreatedBy("Amit");
        book.setBookDescription("my test description");
        book.setCreatedOn(LocalDate.of(2020, 6, 13));
        book.setAuthorName("EPAM");
        book.setLastModifiedOn(LocalDate.of(2020, 6, 13));
        book.setLastModifiedBy("Amit");

        Book book2 = new Book();
        book2.setId(12l);
        book2.setBookName("jpop2");
        book2.setCreatedBy("Sumit");
        book2.setBookDescription("my test description2");
        book2.setCreatedOn(LocalDate.of(2020, Month.JANUARY, 8));
        book2.setAuthorName("EPAM");
        book2.setLastModifiedOn(LocalDate.of(2020, Month.JANUARY, 8));
        book2.setLastModifiedBy("Sumit");

        return Arrays.asList(book, book2);
    }

    private Book getMockData2() {
        Book book = new Book();
        book.setId(1l);
        book.setBookName("jpop");
        book.setCreatedBy("Amit");
        book.setBookDescription("my test description");
        book.setCreatedOn(LocalDate.of(2020, 6, 13));
        book.setAuthorName("EPAM");
        book.setLastModifiedOn(LocalDate.of(2020, 6, 13));
        book.setLastModifiedBy("Amit");
        return book;
    }

}