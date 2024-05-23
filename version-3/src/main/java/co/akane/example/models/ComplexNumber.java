package co.akane.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ComplexNumber extends Number{

    @JsonProperty
    private Double real;
    @JsonProperty
    private Double imaginary;

    @JsonCreator
    public ComplexNumber(
            @JsonProperty("real")
            double real,
            @JsonProperty("imaginary")
            double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public int intValue() {
        return real.intValue();
    }

    @Override
    public long longValue() {
        return real.longValue();
    }

    @Override
    public float floatValue() {
        return real.floatValue();
    }

    @Override
    public double doubleValue() {
        return real;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber)) return false;
        ComplexNumber that = (ComplexNumber) o;
        return real.equals(that.real) && imaginary.equals(that.imaginary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }
}
