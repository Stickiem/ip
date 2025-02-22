package stickiem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void parse_addTaskType_success() {
        assertEquals("add", Parser.parse("todo read book"));
        assertEquals("add", Parser.parse("deadline read textbook /by 2001-10-10"));
        assertEquals("add", Parser.parse("event take exam /from 2001-10-10 /to 2001-10-10"));
    }

}

