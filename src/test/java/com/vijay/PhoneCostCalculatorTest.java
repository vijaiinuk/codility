package com.vijay;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vijay on 2/9/2017.
 */
public class PhoneCostCalculatorTest {
    private PhoneCostCalculator calculator;

    @Before
    public void setup()  {
        calculator = new PhoneCostCalculator();
    }

    @Test
    public void testPhoneCallCost_with_invalid_Inputs()  {

        assertEquals(0, calculator.getTotalCost(""));

        assertEquals(0, calculator.getTotalCost(null));

        assertEquals(0, calculator.getTotalCost("sdfsdf"));

    }

    @Test
    public void testPhoneCallCost_with_valid_strings()  {
        assertEquals(201, calculator.getTotalCost("00:01:07,400-234-090\n" +
                "00:05:07,401-080-090"));

        assertEquals(750,
                calculator.getTotalCost("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090"));
    }

    @Test
    public void testPhoneCallCost_with_invalidInputs_CalcIgnoresInvalids()  {
        assertEquals(201, calculator.getTotalCost("00:01:07,400-234-090\n" +
                "00:05:07,401-080-090\nasdsd"));

        assertEquals(750,
                calculator.getTotalCost("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090\nInvalidStrings"));

    }

}
