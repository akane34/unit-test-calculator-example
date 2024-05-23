package co.akane.example.config;

import co.akane.example.services.Calculator;
import co.akane.example.services.IntegerCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static co.akane.example.models.Constants.INTEGER_CALCULATOR;

@Configuration
public class CalculatorConfig {

    @Bean(INTEGER_CALCULATOR)
    public Calculator getIntegerCalculator() {
        return new IntegerCalculator();
    }
}
