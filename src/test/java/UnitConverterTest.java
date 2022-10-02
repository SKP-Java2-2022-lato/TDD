import org.example.Kilogram;
import org.example.Pound;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static  org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitConverterTest {

    @Test
    void shouldConvertZeroKilogramValue(){
        Pound pound = new Kilogram(BigDecimal.ZERO).toPound();
        assertEquals(BigDecimal.ZERO.setScale(4), pound.value);
    }

    @Test
    void shouldConvertZeroPoundValue(){
        Kilogram kilogram = new Pound(BigDecimal.ZERO).toKilogram();
        assertEquals(BigDecimal.ZERO.setScale(4), kilogram.value);
    }

    @Test
    void shouldConvert1Pound(){
        assertEquals(new BigDecimal("0.4536"), new Pound(BigDecimal.ONE).toKilogram().value);
    }

    @Test
    void shouldConvert1Kilogram(){
        assertEquals(new BigDecimal("2.2046"), new Kilogram(BigDecimal.ONE).toPound().value);
    }

    @Test
    void shouldntAcceptNegativeWeightInPounds(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Pound(new BigDecimal(-1))
        );
        assertEquals(exception.getMessage(), "Masa nie może być ujemna!");

    }

    @Test
    void shouldntAcceptNegativeWeightInKilograms(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Kilogram(new BigDecimal(-1))
        );
        assertEquals(exception.getMessage(), "Masa nie może być ujemna!");

    }
}
