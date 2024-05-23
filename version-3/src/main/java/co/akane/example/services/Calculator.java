package co.akane.example.services;

import co.akane.example.models.Result;

public interface Calculator<T extends Number>
{
    Result<T> sum(Number sum1, Number sum2);
}
