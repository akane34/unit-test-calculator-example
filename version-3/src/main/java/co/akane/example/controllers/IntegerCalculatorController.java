package co.akane.example.controllers;

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

import static co.akane.example.models.Constants.INTEGER_CALCULATOR;

@Slf4j
@RestController
@RequestMapping("/v1/calculator/integer")
public class IntegerCalculatorController {

    private Calculator calculator;

    protected IntegerCalculatorController(
            @Qualifier(INTEGER_CALCULATOR)
            Calculator calculator){
        this.calculator = calculator;
    }

    @PostMapping("/sum")
    public ResponseEntity<Result> sum(@RequestBody List<Integer> sums) {

        Result result = calculator.sum(sums.get(0), sums.get(1));
        if (result.isSuccess())
            return ResponseEntity.ok(result);
        else
            return ResponseEntity.status(result.getCode()).body(result);
    }
}
