package com.epam.libraryservice.cloud.contract;

import com.epam.libraryservice.LibraryServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryServiceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubsMode.LOCAL, ids = { "com.epam:bookservice" })
public class LibraryControllerContractTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void validate_get_books_contract() throws Exception {

        //F-
        mockMvc.perform(MockMvcRequestBuilders.get("/book-service/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id",is(11)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].bookName",is("jpop")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].bookDescription",is("my test description")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorName",is("EPAM")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].createdBy",is("Amit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastModifiedBy",is("Amit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].createdOn",is("2020-06-13")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastModifiedOn",is("2020-01-08")))

                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id",is(12)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].bookName",is("jpop2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].bookDescription",is("my test description2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorName",is("EPAM")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].createdBy",is("Sumit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastModifiedBy",is("Sumit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].createdOn",is("2020-06-13")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastModifiedOn",is("2020-01-08")));

        //F+
    }

    @Test
    public void validate_get_books_by_identifier_contract() throws Exception {

        //F-
        mockMvc.perform(MockMvcRequestBuilders.get("/book-service/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$.id",is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookName",is("jpop")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookDescription",is("my test description")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorName",is("EPAM")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdBy",is("Amit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastModifiedBy",is("Amit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdOn",is("2020-06-13")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastModifiedOn",is("2020-06-13")));


        //F+
    }

}