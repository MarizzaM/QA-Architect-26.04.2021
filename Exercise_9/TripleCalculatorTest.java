package com.company;
import org.junit.Test;

import java.lang.reflect.Field;

import static junit.framework.TestCase.assertEquals;
public class TripleCalculatorTest {

    private int get_m_boomCount(TripleCalculator calculator) {
        try {
            int m_boomCount = 0;
            Field privateStringField = null;
            privateStringField = TripleCalculator.class.
                    getDeclaredField("m_boomCount");
            privateStringField.setAccessible(true);
            m_boomCount = (int) privateStringField.get(calculator);

            return m_boomCount;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Test
    public void test_TripleCalculator_input0(){
        TripleCalculator calculator = new TripleCalculator();
        int number = 0;

        assertEquals(calculator.calc(number), 300);
    }
    
    @Test
    public void test_TripleCalculator_mul3(){
        TripleCalculator calculator = new TripleCalculator();
        int number = 100;

        assertEquals(calculator.calc(number), number*3);
    }

    @Test
    public void test_TripleCalculator_boom(){
        TripleCalculator calculator = new TripleCalculator();
        int number = 7;

        assertEquals(calculator.calc(number), number);
    }

    @Test
    public void test_TripleCalculator_countBoom(){
        TripleCalculator calculator = new TripleCalculator();

        calculator.calc(7);
        calculator.calc(14);
        calculator.calc(21);

        int result = get_m_boomCount(calculator);

        assertEquals(result, 3);
    }

}
