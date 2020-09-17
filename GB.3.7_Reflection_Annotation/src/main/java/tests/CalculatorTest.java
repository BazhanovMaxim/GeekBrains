package tests;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.PageEntry;
import annotations.Test;
import assertions.Assert;
import calculator.Calculator;

@PageEntry(TestsCase = "Проверка калькулятора")
public class CalculatorTest {

    private static Calculator calculator;

    public CalculatorTest() {
    }

    @BeforeSuite
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void after() {}

    @Test(order = 1)
    public boolean firstTest() {
        return Assert.assertEquals(calculator.SumTwoNumbers(10, 10), 25);
    }

    @Test(order = 2)
    public boolean secondTest() {
        return Assert.assertEquals(calculator.multiplyTwoNumbers(10, 10), 20);
    }

    @Test(order = 3)
    public boolean thirdTest() {
        return Assert.assertEquals(calculator.multiplyTwoNumbers(10, 10), 100);
    }

    @Test(order = 4)
    public boolean fourthTest() {
        return Assert.assertEquals(calculator.multiplyTwoNumbers(10, 10), 100);
    }
}
