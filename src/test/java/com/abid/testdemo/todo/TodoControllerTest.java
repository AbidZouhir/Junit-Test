package com.abid.testdemo.todo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoRepository todoRepository;

    @Test
    void shouldFindAllTodos() throws Exception {
        var todos = List.of(new Todo("test 1",true), new Todo("test 2", true));
        Mockito.when(todoRepository.findAll()).thenReturn(todos);
        MvcResult mvcResult =  mockMvc.perform(get("/api/todos")).andReturn();

        assertEquals(200 , mvcResult.getResponse().getStatus());
    }
}