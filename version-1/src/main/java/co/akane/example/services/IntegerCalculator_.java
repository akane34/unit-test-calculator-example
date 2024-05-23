package co.akane.example.services;

import co.akane.example.models.Result;

public class IntegerCalculator_ implements Calculator<Integer> {
    @Override
    public Result<Integer> sum(Number sum1, Number sum2) {

        Result<Integer> result = validateInputs(sum1, sum2);
        if (!result.isSuccess()) return result;

        double sum = sum1.doubleValue() + sum2.doubleValue();
        if (sum > Integer.MAX_VALUE){
            result.setError("El resultado supera el maximo permitido para un numero entero");
            return result;
        }

        result.setResult((int) sum);
        return result;
    }

    private Result<Integer> validateInputs(Number sum1, Number sum2) {
        Result<Integer> result = new Result<Integer>();

        if (sum1 == null || sum2 == null) {
            result.setError("No se permiten valores nulos");
            return result;
        }

        if (!(sum1 instanceof Integer) || !(sum2 instanceof Integer)){
            result.setError("Solo se permiten números enteros");
            return result;
        }

        if (sum1.intValue() < 0 || sum2.intValue() < 0) {
            result.setError("No se permiten numeros negativos");
            return result;
        }

        return result;
    }
}
