import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals(0, standard.getNumerator(), "Standard constructor returns wrong numerator");
        assertEquals(1, standard.getDenominator(), "Standard constructor returns wrong denominator");
    }

    @Test
    public void throwException_whenDenominatorZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            new Rational(2, 0);
        });
        assertEquals("division by zero !", exception.getMessage(), "Denominator can't be zero!");
    }

    @Test
    public void testReduce() {
        Rational custom = new Rational(6, 12);
        Rational expect = new Rational(1, 2);
        assertEquals(expect, custom, "Reduce wrong!");

        Rational custom2 = new Rational(15, 5);
        Rational expect2 = new Rational(3, 1);
        assertEquals(expect2, custom2, "Reduce wrong!");
    }

    @Test
    public void testConvertToNegativeNumber() {
        Rational custom = new Rational(5, -9);
        Rational expect = new Rational(-5, 9);
        assertEquals(expect, custom, "Convert to negative wrong!");
    }

    @Test
    public void testEquals_sameNumeratorOrDenominator() {
        Rational rational1 = new Rational(5, 9);
        Rational rational2 = new Rational(5, 7);
        assertNotEquals(rational1, rational2);

        Rational rational3 = new Rational(3, 7);
        Rational rational4 = new Rational(5, 7);
        assertNotEquals(rational3, rational4);
    }

    @Test
    public void testEquals_sameNumeratorOrDenominator_negativeNumbers() {
        Rational rational1 = new Rational(-5, 9);
        Rational rational2 = new Rational(-5, 7);
        assertNotEquals(rational1, rational2);

        Rational rational3 = new Rational(3, -7);
        Rational rational4 = new Rational(5, -7);
        assertNotEquals(rational3, rational4);
    }

    @Test
    public void testEquals_identicalFractions() {
        Rational rational1 = new Rational(3, 7);
        Rational rational2 = new Rational(3, 7);
        assertEquals(rational1, rational2);
    }

    @Test
    public void testEquals_identicalFractions_negativeNumbers() {
        Rational rational11 = new Rational(-3, 7);
        Rational rational12 = new Rational(-3, 7);
        assertEquals(rational11, rational12);
    }

    @Test
    public void testEquals_differentNumeratorAndDenominator() {
        Rational rational1 = new Rational(3, 7);
        Rational rational2 = new Rational(4, 9);
        assertNotEquals(rational1, rational2);
    }

    @Test
    public void testEquals_differentNumeratorAndDenominator_negativeNumbers() {
        Rational rational1 = new Rational(-3, 7);
        Rational rational2 = new Rational(-4, 9);
        assertNotEquals(rational1, rational2);
    }

    @Test
    public void testLess_sameNumeratorOrDenominator() {
        Rational rational1 = new Rational(3, 7);
        Rational rational2 = new Rational(3, 5);
        assertTrue(rational1.less(rational2));

        Rational rational3 = new Rational(4, 5);
        Rational rational4 = new Rational(3, 5);
        assertTrue(rational4.less(rational3));
    }

    @Test
    public void testLess_differentFractions() {
        Rational rational1 = new Rational(2, 7);
        Rational rational2 = new Rational(3, 5);
        assertTrue(rational1.less(rational2));
    }

    @Test
    public void testLess_identicalFractions() {
        Rational rational1 = new Rational(2, 7);
        Rational rational2 = new Rational(2, 7);
        assertFalse(rational1.less(rational2));
    }

    //тест нашел ошибку
    @Test
    public void testLess_negativeNumbers() {
        Rational rational1 = new Rational(-5, 9);
        Rational rational2 = new Rational(3, 7);
        assertTrue(rational1.less(rational2));
    }

    @Test
    public void testLessOrEqual_sameNumeratorOrDenominator() {
        Rational rational1 = new Rational(3, 7);
        Rational rational2 = new Rational(3, 5);
        assertTrue(rational1.lessOrEqual(rational2));

        Rational rational3 = new Rational(4, 5);
        Rational rational4 = new Rational(3, 5);
        assertTrue(rational4.lessOrEqual(rational3));
    }

    @Test
    public void testLessOrEqual_differentFractions() {
        Rational rational1 = new Rational(2, 7);
        Rational rational2 = new Rational(3, 5);
        assertTrue(rational1.lessOrEqual(rational2));
    }

    @Test
    public void testLessOrEqual_identicalFractions() {
        Rational rational1 = new Rational(2, 7);
        Rational rational2 = new Rational(2, 7);
        assertTrue(rational1.lessOrEqual(rational2));
    }

    @Test
    public void testLessOrEqual_NegativeNumbers() {
        Rational rational1 = new Rational(4, 5);
        Rational rational2 = new Rational(-8, 9);
        assertFalse(rational1.lessOrEqual(rational2));
    }

    @Test
    public void testPlus_positiveNumbers() {
        Rational rational1 = new Rational(2, 7);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(31, 35);
        assertEquals(rational1.plus(rational2), result);
    }

    @Test
    public void testPlus_negativeNumbers() {
        Rational rational1 = new Rational(-2, 7);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(11, 35);
        assertEquals(rational1.plus(rational2), result);
    }

    @Test
    public void testMinus_positiveNumbers() {
        Rational rational1 = new Rational(4, 6);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(1, 15);
        assertEquals(rational1.minus(rational2), result);
    }

    @Test
    public void testMinus_negativeNumbers() {
        Rational rational1 = new Rational(-2, 7);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(-31, 35);
        assertEquals(rational1.minus(rational2), result);
    }

    @Test
    public void testMultiply_positiveNumbers() {
        Rational rational1 = new Rational(4, 6);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(2, 5);
        assertEquals(rational1.multiply(rational2), result);
    }

    @Test
    public void testMultiply_negativeNumbers() {
        Rational rational1 = new Rational(-2, 7);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(-6, 35);
        assertEquals(rational1.multiply(rational2), result);
    }

    @Test
    public void testDivide_positiveNumbers() {
        Rational rational1 = new Rational(4, 6);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(10, 9);
        assertEquals(rational1.divide(rational2), result);
    }

    @Test
    public void testDivide_negativeNumbers() {
        Rational rational1 = new Rational(-2, 7);
        Rational rational2 = new Rational(3, 5);
        Rational result = new Rational(-10, 21);
        assertEquals(rational1.divide(rational2), result);
    }

    @Test
    public void testDivide_throwException_whenDenominatorZero() {
        Rational rational1 = new Rational(2, 3);
        Rational rational2 = new Rational(0, 5);
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            rational1.divide(rational2);
        });
        assertEquals("division by zero !", exception.getMessage(), "Denominator can't be zero!");
    }
}