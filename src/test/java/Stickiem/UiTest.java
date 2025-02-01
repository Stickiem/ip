package Stickiem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    @Test
    public void getActivity_create_success() {
        assertEquals(true, new Ui().getActivity());
    }

}