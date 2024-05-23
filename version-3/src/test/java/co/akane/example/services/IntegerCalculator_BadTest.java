package co.akane.example.services;

import co.akane.example.models.Result;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerCalculator_BadTest
{
    @Test
    public void sumTwoIntegerPositiveAndNegativeAndNullNumbers()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        Integer sum1 = createPositiveNumber();
        Integer sum2 = createPositiveNumber();

        Integer sum3 = createNegativeNumber();
        Integer sum4 = createNegativeNumber();

        Integer sum5 = null;
        Integer sum6 = createNegativeNumber();

        //Execute
        Result<Integer> result1 = calculator.sum(sum1, sum2);
        Result<Integer> result2 = calculator.sum(sum3, sum4);
        Result<Integer> result3 = calculator.sum(sum5, sum6);

        //Then
        assertTrue( 20 == result1.getResult());

        assertTrue( !result2.isSuccess() );
        assertEquals(result2.getError(), "No se permiten numeros negativos");

        assertTrue( !result3.isSuccess() );
        assertEquals(result3.getError(), "No se permiten valores nulos");
    }

    @Test
    public void sumOneIntegerPositiveWithOneNegativeNumber()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        Integer sum1 = createPositiveNumber();
        Integer sum2 = createNegativeNumber();

        //Execute
        Result result = calculator.sum(sum1, sum2);

        //Then
        assertTrue( !result.isSuccess() );
        assertEquals(result.getError(), "No se permiten numeros negativos");
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

    private Integer createPositiveNumber(){
        return 10;
    }

    private Integer createNegativeNumber(){
        return -20;
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
