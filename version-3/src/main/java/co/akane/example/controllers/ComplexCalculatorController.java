package co.akane.example.controllers;

import co.akane.example.models.ComplexNumber;
import co.akane.example.models.Result;
import co.akane.example.services.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static co.akane.example.models.Constants.COMPLEX_CALCULATOR;

@Slf4j
@RestController
@RequestMapping("/v1/calculator/complex")
public class ComplexCalculatorController {

    private final Calculator<ComplexNumber> calculator;

    protected ComplexCalculatorController(
            @Qualifier(COMPLEX_CALCULATOR)
            Calculator<ComplexNumber>  calculator){
        this.calculator = calculator;
    }


    @PostMapping("/sum")
    public ResponseEntity<Result> sum(@RequestBody List<ComplexNumber> sums) {

        Result result = calculator.sum(sums.get(0), sums.get(1));
        if (result.isSuccess())
            return ResponseEntity.ok(result);
        else
            return ResponseEntity.status(result.getCode()).body(result);
    }
}
