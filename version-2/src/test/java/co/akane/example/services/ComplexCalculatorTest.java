package co.akane.example.services;

import co.akane.example.models.ComplexNumber;
import co.akane.example.models.Result;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComplexCalculatorTest
{
    @Test
    public void sumTwoComplexNumberPositiveNumbers()
    {
        //Given
        Calculator calculator = new ComplexCalculator();
        ComplexNumber sum1 = new ComplexNumber(10, 5);
        ComplexNumber sum2 = new ComplexNumber(20, 3);

        //Execute
        Result<ComplexNumber> result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( new ComplexNumber(30, 8).equals(result.getResult()) );
    }

    @Test
    public void sumTwoComplexNumberNegativeNumbers()
    {
        //Given
        Calculator calculator = new ComplexCalculator();
        ComplexNumber sum1 = new ComplexNumber(-10, 15);
        ComplexNumber sum2 = new ComplexNumber(-20, 5);

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( new ComplexNumber(-30, 20).equals(result.getResult()) );
    }

    @Test
    public void sumOneComplexNumberPositiveWithOneNegativeNumber()
    {
        //Given
        Calculator calculator = new ComplexCalculator();
        ComplexNumber sum1 = new ComplexNumber(10, 15);
        ComplexNumber sum2 = new ComplexNumber(-20, 15);

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( new ComplexNumber(-10, 30).equals(result.getResult()) );
    }

    @Test
    public void sumOneNullComplexNumberWithOneNegativeNumber()
    {
        //Given
        Calculator calculator = new ComplexCalculator();
        ComplexNumber sum1 = null;
        ComplexNumber sum2 = new ComplexNumber(-20, 15);

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "No se permiten valores nulos");
    }

    @Test
    public void sumTwoNullComplexNumberNumbers()
    {
        //Given
        Calculator calculator = new ComplexCalculator();
        ComplexNumber sum1 = null;
        ComplexNumber sum2 = null;

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "No se permiten valores nulos");
    }
}
