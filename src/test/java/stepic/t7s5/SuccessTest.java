package stepic.t7s5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SuccessTest {

    @Test
    void whenValueMatchFilterReturnsThis() {
        int n1 = Try.of(() -> Integer.parseInt("100")) // Success[100]
                .filter(value -> value > 50) // Success[100]
                .getUnchecked(); // 100
        assertEquals(100, n1);
    }

    @Test
    void filterWhenValueNotMatchThenRuntimeException() {

        /**/
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            int n2 = Try.of(() -> Integer.parseInt("49")) // Success[100]
                    .filter(value -> value > 50) // Failure[NoSuchElementException]
                    .getUnchecked(); // throws a RuntimeException that wraps NoSuchElementException
        });

        assertEquals(NoSuchElementException.class, thrown.getCause().getClass());
    }

    @Test
    void filterWhenFailureThenRuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            int n3 = Try.of(() -> Integer.parseInt("100K")) // Failure[NumberFormatException]
                    .filter(value -> value > 50) // Failure[IllegalArgumentException]
                    .getUnchecked(); // throws a RuntimeException that wraps IllegalArgumentException
        });

        assertEquals(IllegalArgumentException.class, thrown.getCause().getClass());


    }
}
