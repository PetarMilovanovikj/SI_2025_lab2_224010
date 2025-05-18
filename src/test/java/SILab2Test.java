import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345678"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        Item item2 = new Item("pen", 2, 100, 0.0);
        double result2 = SILab2.checkCart(List.of(item2), "1234567812345678");
        assertEquals(200.0, result2);

        Item item3 = new Item("laptop", 1, 400, 0.1);
        double result3 = SILab2.checkCart(List.of(item3), "1234567812345678");
        assertEquals(330.0, result3);

        Item item4 = new Item("book", 1, 100, 0.0);
        RuntimeException ex4 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(item4), "abcd12345678efgh"));
        assertEquals("Invalid character in card number!", ex4.getMessage());
    }

    @Test
    public void testMultipleCondition() {
        SILab2.checkCart(List.of(new Item("A", 5, 100, 0.0)), "1234567812345678");
        SILab2.checkCart(List.of(new Item("A", 15, 100, 0.0)), "1234567812345678");
        SILab2.checkCart(List.of(new Item("A", 5, 100, 0.2)), "1234567812345678");
        SILab2.checkCart(List.of(new Item("A", 12, 100, 0.2)), "1234567812345678");
        SILab2.checkCart(List.of(new Item("A", 5, 400, 0.0)), "1234567812345678");
        SILab2.checkCart(List.of(new Item("A", 12, 400, 0.0)), "1234567812345678");
        SILab2.checkCart(List.of(new Item("A", 5, 400, 0.2)), "1234567812345678");
        SILab2.checkCart(List.of(new Item("A", 12, 400, 0.2)), "1234567812345678");
    }
}
