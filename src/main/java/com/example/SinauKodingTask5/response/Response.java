package com.example.SinauKodingTask5.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Response implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer count;
    HttpStatus httpStatus;

    public  Response(Object data, String message, HttpStatus httpStatus){
        this.data=data;
        this.message=message;
        this.httpStatus=httpStatus;
    }

    public  Response(Object data, String message, Integer count, HttpStatus httpStatus){
        this.data=data;
        this.message=message;
        this.count=count;
        this.httpStatus=httpStatus;
    }
}
