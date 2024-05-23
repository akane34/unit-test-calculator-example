package co.akane.example.controllers;

import co.akane.example.models.ComplexNumber;
import co.akane.example.models.Result;
import co.akane.example.services.Calculator;
import co.akane.example.services.ComplexCalculator;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComplexCalculatorControllerIntegrationTest {

    @Test
    public void sumTwoComplexPositiveNumbers()
    {
        //Given
        Calculator calculator = new ComplexCalculator();
        ComplexCalculatorController controller = new ComplexCalculatorController(calculator);
        ComplexNumber sum1 = new ComplexNumber(10, 5);
        ComplexNumber sum2 = new ComplexNumber(20, 5);

        //Execute
        ResponseEntity response = controller.sum(List.of(sum1, sum2));

        //Then
        assertEquals( 200, response.getStatusCode());
        assertTrue( response.getBody() instanceof Result);
        assertEquals( new ComplexNumber(30, 10), ((Result)response.getBody()).getResult());
    }

    @Test
    public void sumTwoNegativeNumbers()
    {
        //Given
        Calculator calculator = new ComplexCalculator();
        ComplexCalculatorController controller = new ComplexCalculatorController(calculator);
        ComplexNumber sum1 = new ComplexNumber(-10, 5);
        ComplexNumber sum2 = new ComplexNumber(-10, 5);

        //Execute
        ResponseEntity response = controller.sum(List.of(sum1, sum2));

        //Then
        assertEquals( 200, response.getStatusCode());
        assertTrue( response.getBody() instanceof Result);
        assertEquals( new ComplexNumber(-20, 10), ((Result)response.getBody()).getResult());
    }
}
