package com.abid.testdemo.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TodoJunitTest {

    @Test
    void shouldCreateNewTodo(){
        var test = new Todo("TEST", false);

        assertEquals("TEST",test.name(),"Todo name was  not equals to TEST");
        assertFalse(test.completed());

    }
}
