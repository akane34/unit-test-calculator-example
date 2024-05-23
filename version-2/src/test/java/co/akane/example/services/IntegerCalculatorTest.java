package co.akane.example.services;

import co.akane.example.models.Result;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerCalculatorTest
{
    @Test
    public void sumTwoIntegerPositiveNumbers()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        Integer sum1 = 10;
        Integer sum2 = 20;

        //Execute
        Result<Integer> result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( 30 == result.getResult() );
    }

    @Test
    public void sumTwoIntegerNegativeNumbers()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        Integer sum1 = -10;
        Integer sum2 = -20;

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "No se permiten numeros negativos");
    }

    @Test
    public void sumOneIntegerPositiveWithOneNegativeNumber()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        Integer sum1 = 10;
        Integer sum2 = -20;

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "No se permiten numeros negativos");
    }

    @Test
    public void sumOneNullIntegerWithOneNegativeNumber()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        Integer sum1 = null;
        Integer sum2 = -20;

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "No se permiten valores nulos");
    }

    @Test
    public void sumTwoNullIntegerNumbers()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        Integer sum1 = null;
        Integer sum2 = null;

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "No se permiten valores nulos");
    }

    /*
    @Test
    public void sumOneMaxEdgeNumber() {
        //Given
        Calculator calculator = new IntegerCalculator();
        //Max int is 2^31 - 1 = 2.147'483.647
        Integer sum1 = Integer.parseInt("2147483647");
        Integer sum2 = Integer.parseInt("1");

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "El resultado supera el maximo permitido para un numero entero");
    }

    @Test
    public void sumTwoMaxEdgeNumber() {
        //Given
        Calculator calculator = new IntegerCalculator();
        //Max int is 2^31 - 1 = 2.147'483.647
        Integer sum1 = Integer.parseInt("2147483647");
        Integer sum2 = Integer.parseInt("2147483647");

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "El resultado supera el maximo permitido para un numero entero");
    }

    @Test
    public void sumTwoNumbersWithResultMaxEdge() {
        //Given
        Calculator calculator = new IntegerCalculator();
        //Max int is 2^31 - 1 = 2.147'483.647
        Integer sum1 = Integer.parseInt("2147483647");
        Integer sum2 = Integer.parseInt("-2147483647");

        //Execute
        Result<Integer> result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( 0 == result.getResult() );
    }
    */
}
