package org.example;

import java.math.BigDecimal;

public class Kilogram implements WeightUnit {

    public final BigDecimal value;

    public Kilogram(BigDecimal value) {
        if(BigDecimal.ZERO.compareTo(value) > 0)
            throw new IllegalArgumentException("Masa nie może być ujemna!");
        this.value = value.setScale(SCALE, ROUNDING_MODE );
    }

    public Pound toPound(){
        return new Pound(value.divide(Pound.POUND_TO_KILOGRAM_RATIO, SCALE, ROUNDING_MODE));
    }
}
