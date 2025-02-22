package stickiem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void getDetails_display_success() {
        assertEquals("[T][ ] Read book", new ToDo("Read book", false).getDetails());
        assertEquals("[T][X] Read paper", new ToDo("Read paper", true).getDetails());
    }

    @Test
    public void getType_display_success() {
        assertEquals("todo", new ToDo("Read book", false).getType());
        assertEquals("todo", new ToDo("Read paper", true).getType());
    }

    @Test
    public void getCommand_display_success() {
        assertEquals(" todo Read book", new ToDo("Read book", false).getCommand());
        assertEquals("X todo Read paper", new ToDo("Read paper", true).getCommand());
    }

}