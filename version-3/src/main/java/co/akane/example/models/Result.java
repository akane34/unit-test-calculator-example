package co.akane.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {

    @JsonProperty
    private T result;
    @JsonProperty
    private String error;

    public boolean isSuccess(){
        return error == null || error.isEmpty();
    }

    public T getResult(){
        return result;
    }

    public Result setResult(T result){
        this.result = result;
        return this;
    }

    public String getError(){
        return error;
    }

    public Result setError(String error) {
        this.error = error;
        return this;
    }

    public int getCode() {
        if (isSuccess())
            return 200;
        else
            return 400;
    }
}
