import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiscountCalculatorTest {

    DiscountCalculator calculator = new DiscountCalculator();

    @ParameterizedTest
    @CsvSource({
            "NEW, 5, false, 5",
            "NEW, 5, true, 7",
            "REGULAR, 5, false, 8",
            "REGULAR, 10, true, 15",
            "PREMIUM, 5, true, 12",
            "PREMIUM, 10, false, 15"
    })
    void testCalculateDiscount(String customerType,
                               int totalOrdersInLastYear,
                               boolean isSubscribedToNewsletter,
                               int expectedDiscount) {

        int actualDiscount = calculator.calculateDiscount(
                customerType,
                totalOrdersInLastYear,
                isSubscribedToNewsletter
        );

        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    void testInfeasibleCombination() {

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDiscount("NEW", 10, true);
        });
    }
}