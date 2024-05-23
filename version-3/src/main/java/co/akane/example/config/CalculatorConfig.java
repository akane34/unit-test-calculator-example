package co.akane.example.config;

import co.akane.example.services.Calculator;
import co.akane.example.services.ComplexCalculator;
import co.akane.example.services.IntegerCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static co.akane.example.models.Constants.COMPLEX_CALCULATOR;
import static co.akane.example.models.Constants.INTEGER_CALCULATOR;

@Configuration
public class CalculatorConfig {

    @Bean(INTEGER_CALCULATOR)
    public Calculator getIntegerCalculator() {
        return new IntegerCalculator();
    }

    @Bean(COMPLEX_CALCULATOR)
    public Calculator getComplexCalculator() {
        return new ComplexCalculator();
    }
}
