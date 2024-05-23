package co.akane.example.services;

import co.akane.example.models.ComplexNumber;
import co.akane.example.models.Result;

public class ComplexCalculator_ implements Calculator<ComplexNumber> {

    @Override
    public Result<ComplexNumber> sum(Number sum1, Number sum2) {

        Result<ComplexNumber> result = validateInputs(sum1, sum2);
        if (!result.isSuccess()) return result;

        ComplexNumber sum1C = (ComplexNumber)sum1;
        ComplexNumber sum2C = (ComplexNumber)sum2;


        result.setResult(new ComplexNumber(sum1C.getReal() + sum2C.getReal(), sum1C.getImaginary() + sum2C.getImaginary()));
        return result;
    }

    private Result<ComplexNumber> validateInputs(Number sum1, Number sum2) {
        Result<ComplexNumber> result = new Result<ComplexNumber>();

        if (sum1 == null || sum2 == null) {
            result.setError("No se permiten valores nulos");
            return result;
        }

        if (!(sum1 instanceof ComplexNumber) || !(sum2 instanceof ComplexNumber)){
            result.setError("Solo se permiten números complejos");
            return result;
        }

        return result;
    }
}
