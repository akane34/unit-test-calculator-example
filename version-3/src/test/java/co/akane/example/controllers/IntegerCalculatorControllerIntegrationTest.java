package co.akane.example.controllers;

import co.akane.example.models.Result;
import co.akane.example.services.Calculator;
import co.akane.example.services.IntegerCalculator;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerCalculatorControllerIntegrationTest {

    @Test
    public void sumTwoIntegerPositiveNumbers()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        IntegerCalculatorController controller = new IntegerCalculatorController(calculator);
        Integer sum1 = 10;
        Integer sum2 = 20;

        //When
        ResponseEntity response = controller.sum(List.of(sum1, sum2));

        //Then
        assertEquals( 200, response.getStatusCode());
        assertTrue( response.getBody() instanceof Result);
        assertEquals( 30, ((Result)response.getBody()).getResult());
    }

    @Test
    public void sumTwoNegativeNumbers()
    {
        //Given
        Calculator calculator = new IntegerCalculator();
        IntegerCalculatorController controller = new IntegerCalculatorController(calculator);
        Integer sum1 = -10;
        Integer sum2 = -20;

        //When
        ResponseEntity response = controller.sum(List.of(sum1, sum2));

        //Then
        assertEquals( 400, response.getStatusCode());
        assertTrue( response.getBody() instanceof Result);
        assertEquals( "No se permiten numeros negativos", ((Result)response.getBody()).getError());
    }
}
