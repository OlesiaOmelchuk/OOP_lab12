import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.chainofresponsibility.ATM;

public class TestTask1 {
    @Test
    public void testATM() {
        ATM atm = new ATM();
        Assertions.assertDoesNotThrow(() -> atm.process(125));
        Assertions.assertThrows(IllegalArgumentException.class, () -> atm.process(27));
    }
}
